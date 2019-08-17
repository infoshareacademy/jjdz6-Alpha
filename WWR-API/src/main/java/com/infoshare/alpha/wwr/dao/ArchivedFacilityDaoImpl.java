package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.ArchivedFacility;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequestScoped
public class ArchivedFacilityDaoImpl implements ArchivedFacilityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ArchivedFacility> findByDate(LocalDate date) {
        final Query query = entityManager.createQuery("SELECT a FROM ArchivedFacility a WHERE a.timestamp BETWEEN :startOfDay AND :endOfDay");
        query.setParameter("startOfDay", date.atTime(LocalTime.MIN));
        query.setParameter("endOfDay", date.atTime(LocalTime.MAX));
        return query.getResultList();
    }

    @Override
    public List<ArchivedFacility> findAll() {
        final Query query = entityManager.createQuery("SELECT a FROM ArchivedFacility a");
        return query.getResultList();
    }

    @Override
    public ArchivedFacility addArchivedFacility(ArchivedFacility archivedFacility) {
        entityManager.persist(archivedFacility);
        return archivedFacility;
    }
}
