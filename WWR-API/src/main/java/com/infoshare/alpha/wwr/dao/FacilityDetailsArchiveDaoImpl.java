package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.FacilityDetailsArchive;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequestScoped
public class FacilityDetailsArchiveDaoImpl implements FacilityDetailsArchiveDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public Optional<FacilityDetailsArchive> findById(Long id) {
//        return Optional.ofNullable(entityManager.find(FacilityDetailsArchive.class, id));
//    }


    @Override
    public List<FacilityDetailsArchive> findByDate(LocalDate date) {
        final Query query = entityManager.createQuery("SELECT f FROM FacilityDetailsArchive f WHERE f.timestamp BETWEEN :startOfDay AND :endOfDay");
        query.setParameter("startOfDay", date.atTime(LocalTime.MIN));
        query.setParameter("endOfDay", date.atTime(LocalTime.MAX));
        return query.getResultList();
    }

    @Override
    public List<FacilityDetailsArchive> findAll() {
        final Query query = entityManager.createQuery("SELECT f FROM FacilityDetailsArchive f");
        return query.getResultList();
    }

    @Override
    public FacilityDetailsArchive addFacilityDetails(FacilityDetailsArchive facilityDetailsArchive) {
        entityManager.persist(facilityDetailsArchive);
        return facilityDetailsArchive;
    }
}
