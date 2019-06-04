package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class FacilitiesServiceTest {

    @InjectMocks
    private FacilitiesService testObj;

    @Mock
    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

    @Mock
    private FacilitiesRepository facilitiesDbRepository;

    @Test
    @DisplayName("Should add facility")
    void add() {

    }

    void delete() {
    }

    @Test
    @DisplayName("Should edit facility")
    void edit() {
    }


    void upload() {
    }
}