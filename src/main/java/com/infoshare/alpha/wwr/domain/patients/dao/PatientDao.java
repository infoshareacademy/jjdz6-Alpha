package com.infoshare.alpha.wwr.domain.patients.dao;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Patient> findAll() {

        final TypedQuery<Patient> patientQuery = entityManager.createQuery("SELECT p FROM Patient p", Patient.class);

        return patientQuery.getResultList();
    }
}
