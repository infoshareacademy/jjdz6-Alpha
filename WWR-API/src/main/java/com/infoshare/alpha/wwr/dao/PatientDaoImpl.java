package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.Patient;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class PatientDaoImpl implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Patient> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Patient.class, id));
    }

    @Override
    public List<Patient> findAll() {
        final Query query = entityManager.createQuery("SELECT p FROM Patient p");
        return query.getResultList();
    }
}
