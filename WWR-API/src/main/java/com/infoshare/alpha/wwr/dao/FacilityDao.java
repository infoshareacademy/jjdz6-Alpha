package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import java.util.List;
import java.util.Optional;

public interface FacilityDao {

    Optional<Facility> findById(int id);

    List<Facility> findAll();

}
