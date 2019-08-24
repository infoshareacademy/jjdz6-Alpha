package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.SearchBarQueryDao;
import com.infoshare.alpha.wwr.entity.SearchBarQuery;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class SearchBarQueriesServiceTest {

    @InjectMocks
    private final SearchBarQueriesService testObj = new SearchBarQueriesService();
    @Mock
    private SearchBarQueryDao searchBarQueryDao;
    @Mock
    private Logger logger;

    @Test
    @DisplayName("Should return SearchBarQuery when SearchBarQuery with given id is present")
    void getById_returnsSearchBarQuery() {
        // given
        Long id = 1L;
        SearchBarQuery searchBarQuery = new SearchBarQuery();
        Mockito.when(searchBarQueryDao.findById(id)).thenReturn(Optional.ofNullable(searchBarQuery));

        // when
        SearchBarQuery result = testObj.getById(id);

        // then
        Mockito.verify(searchBarQueryDao, Mockito.times(2)).findById(id);
        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(SearchBarQuery.class);
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when SearchBarQuery with given id is not present")
    void getById_throwsResourceNotFoundException() {
        // given
        Long id = 1L;
        Mockito.when(searchBarQueryDao.findById(id)).thenReturn(Optional.ofNullable(null));

        // when & then
        assertThatThrownBy(() -> testObj.getById(id))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Query with ID " + id + " not found");
        Mockito.verify(searchBarQueryDao, Mockito.times(1)).findById(id);
        Mockito.verify(logger, Mockito.times(1)).warn(anyString(), anyLong());
    }
}
