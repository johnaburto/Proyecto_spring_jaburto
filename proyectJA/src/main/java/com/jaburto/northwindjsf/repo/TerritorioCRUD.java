package com.jaburto.northwindjsf.repo;

import com.jaburto.northwindjsf.model.entity.Territorio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TerritorioCRUD extends CrudRepository<Territorio, Integer> {
    List<Territorio> findAllByDescTerritorioEquals(String territry);
}
