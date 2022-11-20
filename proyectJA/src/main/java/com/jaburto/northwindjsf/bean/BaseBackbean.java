package com.jaburto.northwindjsf.bean;

import com.jaburto.northwindjsf.model.dto.Cliente;
import com.jaburto.northwindjsf.model.entity.Region;
import com.jaburto.northwindjsf.model.entity.Territorio;
import com.jaburto.northwindjsf.rest.RestClient;
import com.jaburto.northwindjsf.service.RegionService;
import com.jaburto.northwindjsf.service.TerritorioService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@Scope("session")
@Component
public class BaseBackbean implements Serializable {

    private List<Territorio> territorios;
    private List<Region> regiones;

    private Integer id;
    private String nombre;
    private Integer somRegion;

    private List<Cliente> clientes;
    private final TerritorioService territorioService;
    private final RegionService regionService;
    private final RestClient restClient;

    @Autowired
    public BaseBackbean(TerritorioService territorioService, RegionService regionService, RestClient restClient) {
        this.territorioService = territorioService;
        this.regionService = regionService;
        this.restClient = restClient;
    }

    @PostConstruct
    private void init() {
        limpiar();
    }

    public void guardar() {

        try {
            Region region = new Region();
            region.setIdRegion(somRegion);

            Territorio territorio = new Territorio();
            territorio.setIdTerritorio(id);
            territorio.setDescTerritorio(nombre);
            territorio.setRegion(region);
            territorioService.nuevaTerritorio(territorio);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guadado", "Registro guardado con exito"));
            PrimeFaces.current().ajax().update("growl");
            limpiar();
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error al guardar"));
            PrimeFaces.current().ajax().update("growl");
        }
    }

    private void reloadTerritorios() {
        territorios = territorioService.obtenerTerritorio();
    }

    private void loadFromAPI() {
        clientes = Arrays.asList(restClient.getList("jdreyes/customer/", Cliente.class));
    }


    private void limpiar() {
        reloadTerritorios();
        regiones = regionService.obtenerRegiones();
        territorios.sort(Comparator.comparing(Territorio::getIdTerritorio).reversed());
        loadFromAPI();
        id = null;
        nombre = null;
        somRegion = null;
    }


}
