package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.Patient;
import com.infoshare.alpha.wwr.exceptions.PatientNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PatientsService {

    @Inject
    PatientDao patientDao;

    public Patient getById(Long id) throws PatientNotFoundException {
        return patientDao.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient with ID " + id + " not found"));
    }

    public List<Patient> getPatientsList() {
        return patientDao.findAll();
    }
}
