package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.SearchBarQuery;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class SearchBarQueryDaoImpl implements SearchBarQueryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<SearchBarQuery> findById(Long id) {
        return Optional.ofNullable(entityManager.find(SearchBarQuery.class, id));
    }

    @Override
    public List<SearchBarQuery> findByDate(LocalDate date) {
        final Query query = entityManager.createQuery("SELECT s FROM SearchBarQuery s WHERE s.timestamp BETWEEN :startOfDay AND :endOfDay");
        query.setParameter("startOfDay", date.atTime(LocalTime.MIN));
        query.setParameter("endOfDay", date.atTime(LocalTime.MAX));
        return query.getResultList();
    }

    @Override
    public List<SearchBarQuery> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM SearchBarQuery s");
        return query.getResultList();
    }

    @Override
    public SearchBarQuery addSearchBarQuery(SearchBarQuery searchBarQuery) {
        entityManager.persist(searchBarQuery);
        return searchBarQuery;
    }
}
