package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.SearchBarQuery;

import java.util.List;
import java.util.Optional;

public interface SearchBarQueryDao {

    Optional<SearchBarQuery> findById(int id);

    List<SearchBarQuery> findAll();

    SearchBarQuery addSearchBarQuery(SearchBarQuery searchBarQuery);
}
