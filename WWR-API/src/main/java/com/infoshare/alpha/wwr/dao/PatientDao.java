package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientDao {

    Optional<Patient> findById(int id);

    List<Patient> findAll();
}
