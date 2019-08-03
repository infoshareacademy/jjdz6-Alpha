package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.Patient;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PatientsService {

    @Inject
    PatientDao patientDao;

    public Patient getById(int id) {
//        return patientDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient with ID " + id + " not found"));
        if (patientDao.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Patient with ID " + id + " not found");
        } else {
            return patientDao.findById(id).get();
        }
    }

    public List<Patient> getPatientsList() {
        return patientDao.findAll();
    }
}
