package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class FacilityDaoImpl implements FacilityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Facility> findById(int id) {
        return Optional.ofNullable(entityManager.find(Facility.class, id));
    }

    @Override
    public List<Facility> findAll() {
        final Query query = entityManager.createQuery("SELECT f FROM Facility f");
        return query.getResultList();
    }
}
