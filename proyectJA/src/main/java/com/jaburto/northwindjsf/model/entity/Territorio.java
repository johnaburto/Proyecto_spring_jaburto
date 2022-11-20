package com.jaburto.northwindjsf.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Territories")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTerritorio")
public class Territorio {

    @Id
    @Column(name = "TerritoryID")
    private Integer idTerritorio;

    @Column(name = "TerritoryDescription")
    private String descTerritorio;

    @JoinColumn(name = "RegionID")
    @ManyToOne
    private Region region;
}
