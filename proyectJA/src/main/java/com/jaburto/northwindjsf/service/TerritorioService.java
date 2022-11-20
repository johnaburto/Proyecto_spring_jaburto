package com.jaburto.northwindjsf.service;

import com.jaburto.northwindjsf.model.entity.Territorio;
import com.jaburto.northwindjsf.repo.TerritorioCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TerritorioService {

    private final TerritorioCRUD territorioCRUD;

    @Autowired
    public TerritorioService(TerritorioCRUD territorioCRUD) {
        this.territorioCRUD = territorioCRUD;
    }


    public List<Territorio> obtenerTerritorio() {
        return (List<Territorio>) territorioCRUD.findAll();
    }

    public Territorio nuevaTerritorio(Territorio r) {
        return territorioCRUD.save(r);
    }
}
