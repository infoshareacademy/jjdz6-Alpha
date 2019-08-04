package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.SearchBarQueryDao;
import com.infoshare.alpha.wwr.domain.SearchBarQuery;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class SearchBarQueriesService {

    @Inject
    SearchBarQueryDao searchBarQueryDao;

    public SearchBarQuery getById(int id) {
        if (searchBarQueryDao.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Query with ID " + id + " not found");
        } else {
            return searchBarQueryDao.findById(id).get();
        }
    }

    public List<SearchBarQuery> getSearchBarQueriesList() {
        return searchBarQueryDao.findAll();
    }
}
