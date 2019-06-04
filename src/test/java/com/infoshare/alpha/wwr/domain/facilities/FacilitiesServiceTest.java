package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FacilitiesServiceTest {

    @InjectMocks
    private FacilitiesService testObj;

    @Mock
    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

    @Mock
    private FacilitiesRepository facilitiesDbRepository;

    @Test
    @DisplayName("Should edit facility")
    void edit() {

        // given
        List<Service> services = getFacilityServices();

        Facility oldFacility = new Facility(1, "old_facility", new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"), services);
        Facility editedFacility = new Facility(1, "edited_facility", new Address("Gdańsk-updated", "Kolejowa 24", "+48 111 222 333"), services);

        FacilityEditCommand facilityEditCommand = new FacilityEditCommand(oldFacility, editedFacility);

        List<Facility> facilitiesList = new ArrayList<>();
        facilitiesList.add(oldFacility);

        Facilities facilities = Mockito.mock(Facilities.class);

        // when
        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        try {
            testObj.edit(facilityEditCommand);
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        // then
        Mockito.verify(facilities, Mockito.times(5)).getFacilities();
        Mockito.verify(facilitiesReadModelDbRepository, Mockito.times(1)).getAll();
        Mockito.verify(facilitiesDbRepository, Mockito.times(1)).add(facilities);
    }

    private static List<Service> getFacilityServices() {
        List<Service> services = new ArrayList<>();
        services.add(new Service("wspomaganie-1"));
        services.add(new Service("wspomaganie-2"));
        services.add(new Service("wspomaganie-3"));
        return services;
    }

    @Test
    @DisplayName("Should not edit facility when not found")
    void shouldNotEditFacilityWhenNotFound() {

    }

}