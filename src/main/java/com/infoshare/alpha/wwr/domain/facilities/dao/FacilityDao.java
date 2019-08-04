package com.infoshare.alpha.wwr.domain.facilities.dao;

import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class FacilityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Facility> findAll() {
        final TypedQuery<Facility> facilityQuery = entityManager.createQuery("SELECT f FROM Facility f", Facility.class);

        return facilityQuery.getResultList();
    }

    public Facility update(Facility facility) {
        return entityManager.merge(facility);
    }

    public Facility getById(int id) throws FacilitiesException {
        final Facility facility = entityManager.find(Facility.class, id);

        if (facility == null) {
            throw FacilitiesException.facilityNotFound();
        }

        return facility;
    }

    public void add(Facility facility) {
        entityManager.persist(facility);
    }

    public void remove(Facility facility) {
        entityManager.remove(facility);
    }
}
