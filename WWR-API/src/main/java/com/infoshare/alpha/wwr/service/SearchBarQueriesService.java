package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.SearchBarQueryDao;
import com.infoshare.alpha.wwr.domain.SearchBarQuery;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class SearchBarQueriesService {

    @Inject
    Logger logger;

    @Inject
    SearchBarQueryDao searchBarQueryDao;

    public SearchBarQuery getById(int id) {
        if (searchBarQueryDao.findById(id).isPresent()) {
            return searchBarQueryDao.findById(id).get();
        } else {
            logger.warn("SearchBarQuery with ID: {} has not been found.", id);
            throw new ResourceNotFoundException("Query with ID " + id + " not found");
        }
    }

    public List<SearchBarQuery> getSearchBarQueriesList() {
        return searchBarQueryDao.findAll();
    }
}
