package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.SearchBarQuery;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class SearchBarQueryDaoImpl implements SearchBarQueryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<SearchBarQuery> findById(int id) {
        return Optional.ofNullable(entityManager.find(SearchBarQuery.class, id));
    }

    @Override
    public List<SearchBarQuery> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM SearchBarQuery s");
        return query.getResultList();
    }
}
