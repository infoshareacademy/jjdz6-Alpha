package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.Patient;
import com.infoshare.alpha.wwr.exceptions.IdNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PatientsService {

    @Inject
    PatientDao patientDao;

    public Patient getById(Long id) throws IdNotFoundException {
        return patientDao.findById(id).orElseThrow(() -> new IdNotFoundException("Patient with ID " + id + " not found"));
    }

    public List<Patient> getPatientsList() {
        return patientDao.findAll();
    }
}
