package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.Patient;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PatientsService {

    @Inject
    Logger logger;

    @Inject
    PatientDao patientDao;

    public Patient getById(int id) {
        if (patientDao.findById(id).isPresent()) {
            return patientDao.findById(id).get();
        } else {
            logger.warn("Patient with ID: {} has not been found.", id);
            throw new ResourceNotFoundException("Patient with ID " + id + " not found");
        }
    }

    public List<Patient> getPatientsList() {
        return patientDao.findAll();
    }
}
