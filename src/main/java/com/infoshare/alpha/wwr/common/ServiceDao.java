package com.infoshare.alpha.wwr.common;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Service> findAll() {

        final TypedQuery<Service> serviceQuery = entityManager.createQuery("SELECT s FROM Service s", Service.class);

        return serviceQuery.getResultList();
    }

}
