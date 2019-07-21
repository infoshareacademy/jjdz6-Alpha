package com.infoshare.alpha.wwr.domain.patients.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ParentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Parent> findAll() {

        final TypedQuery<Parent> parentQuery = entityManager.createQuery("SELECT p FROM Parent p", Parent.class);

        return parentQuery.getResultList();
    }
}
