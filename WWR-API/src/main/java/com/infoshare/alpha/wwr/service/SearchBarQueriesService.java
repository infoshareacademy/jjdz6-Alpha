package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.SearchBarQueryDao;
import com.infoshare.alpha.wwr.domain.SearchBarQuery;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class SearchBarQueriesService {

    private final Logger logger = LoggerFactory.getLogger(SearchBarQueriesService.class.getName());

    @Inject
    SearchBarQueryDao searchBarQueryDao;

    public SearchBarQuery getById(int id) {
        if (searchBarQueryDao.findById(id).isEmpty()) {
            logger.warn("SearchBarQuery with ID: {} has not been found. ResourceNotFoundException will be thrown.", id);
            throw new ResourceNotFoundException("Query with ID " + id + " not found");
        } else {
            return searchBarQueryDao.findById(id).get();
        }
    }

    public List<SearchBarQuery> getSearchBarQueriesList() {
        return searchBarQueryDao.findAll();
    }
}
