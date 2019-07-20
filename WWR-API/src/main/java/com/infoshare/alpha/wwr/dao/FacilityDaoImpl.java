package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.Facility;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@RequestScoped
public class FacilityDaoImpl implements FacilityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Facility> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Facility.class, id));
    }
}
