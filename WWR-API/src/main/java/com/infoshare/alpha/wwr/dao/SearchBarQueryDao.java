package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.SearchBarQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SearchBarQueryDao {

    Optional<SearchBarQuery> findById(Long id);

    List<SearchBarQuery> findByDate(LocalDate date);

    List<SearchBarQuery> findAll();

    SearchBarQuery addSearchBarQuery(SearchBarQuery searchBarQuery);
}
