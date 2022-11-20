package com.jaburto.northwindjsf.repo;

import com.jaburto.northwindjsf.model.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionCRUD extends CrudRepository<Region, Integer> {
}
