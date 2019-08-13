package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.SearchBarQueryDao;
import com.infoshare.alpha.wwr.domain.SearchBarQuery;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class SearchBarQueriesService {

    @Inject
    Logger logger;

    @Inject
    SearchBarQueryDao searchBarQueryDao;

    public SearchBarQuery getById(Long id) {
        if (searchBarQueryDao.findById(id).isPresent()) {
            return searchBarQueryDao.findById(id).get();
        } else {
            logger.warn("SearchBarQuery with ID: {} has not been found.", id);
            throw new ResourceNotFoundException("Query with ID " + id + " not found");
        }
    }

    public List<SearchBarQuery> getByDate(LocalDate date) {
        return searchBarQueryDao.findByDate(date);
    }

    public List<SearchBarQuery> getSearchBarQueriesList() {
        return searchBarQueryDao.findAll();
    }

    @Transactional
    public SearchBarQuery saveSearchBarQuery(SearchBarQuery searchBarQuery) {
        return searchBarQueryDao.addSearchBarQuery(searchBarQuery);
    }
}
