package com.infoshare.alpha.wwr.common;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PeselDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pesel> findAll() {

        final TypedQuery<Pesel> peselQuery = entityManager.createQuery("SELECT p FROM Pesel p", Pesel.class);

        return peselQuery.getResultList();
    }

}
