package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class FacilitiesServiceTest {

    @InjectMocks
    private FacilitiesService testObj;

    @Mock
    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

    @Mock
    private FacilitiesRepository facilitiesDbRepository;

    @Test
    @DisplayName("Should add facility")
    void shouldAdd() {

        // given

        List<Service> services = getFacilityServices();
        Facility facility1 = new Facility(
                1,
                "old_facility",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        Facility facility2 = new Facility(
                2,
                "facility1",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        List<Facility> facilitiesList = new ArrayList<>();
        facilitiesList.add(facility1);
        Facilities facilities = Mockito.mock(Facilities.class);

        FacilityAddCommand facilityAddCommand = new FacilityAddCommand(facility2);

        // when

        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        try {
            testObj.add(facilityAddCommand);
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        // then

        Mockito.verify(facilitiesReadModelDbRepository, Mockito.times(1)).getAll();
        Mockito.verify(facilitiesDbRepository, Mockito.times(1)).add(facilities);
        Mockito.verify(facilities, Mockito.times(1)).add(facility2);
    }

    @Test
    @DisplayName("Should not add facility when facility already exists")
    void shouldNotAddWhenFacilityAlreadyExists() {

        // given

        List<Service> services = getFacilityServices();
        Facility facility1 = new Facility(
                1,
                "old_facility",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        List<Facility> facilitiesList = new ArrayList<>();
        facilitiesList.add(facility1);
        Facilities facilities = Mockito.mock(Facilities.class);

        FacilityAddCommand facilityAddCommand = new FacilityAddCommand(facility1);

        // when/then

        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        assertThatThrownBy(() -> testObj.add(facilityAddCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility " + facility1.getName() + " already exists ");

    }

    @Test
    @DisplayName("Should delete facility")
    void shouldDeleteFacility() {

        // given

        List<Service> services = getFacilityServices();
        Facility facility1 = new Facility(
                1,
                "facility-1",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        List<Facility> facilitiesList = new ArrayList<>();
        facilitiesList.add(facility1);
        Facilities facilities = Mockito.mock(Facilities.class);

        // when

        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        FacilityDeleteCommand facilityDeleteCommand = new FacilityDeleteCommand(facility1);

        try {
            testObj.delete(facilityDeleteCommand);
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        // then

        Mockito.verify(facilitiesDbRepository, Mockito.times(1)).add(facilities);
    }

    @Test
    @DisplayName("Should not delete facility while not exist.")
    void shouldNotDeleteFacilityWhileNotExist() {

        // given

        List<Service> services = getFacilityServices();
        Facility facility1 = new Facility(
                1,
                "facility-1",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        List<Facility> facilitiesList = new ArrayList<>();
        Facilities facilities = Mockito.mock(Facilities.class);

        FacilityDeleteCommand facilityDeleteCommand = new FacilityDeleteCommand(facility1);

        // when/then

        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        assertThatThrownBy(() -> testObj.delete(facilityDeleteCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility " + facility1.getName() + " not found ");

    }

    @Test
    @DisplayName("Should edit facility")
    void shouldEdit() {

        // given

        List<Service> services = getFacilityServices();

        Facility oldFacility = new Facility(
                1,
                "old_facility",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        Facility editedFacility = new Facility(
                1,
                "edited_facility",
                new Address("Gdańsk-updated", "Kolejowa 24", "+48 111 222 333"),
                services
        );

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

    @Test
    @DisplayName("Should not edit facility when not found in source")
    void shouldNotEditFacilityWhenNotFound() {

        // given

        List<Service> services = getFacilityServices();

        Facility facility1 = new Facility(2, "facility1", new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"), services);
        Facility facility2 = new Facility(3, "facility2", new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"), services);
        Facility editedFacility = new Facility(1, "edited_facility", new Address("Gdańsk-updated", "Kolejowa 24", "+48 111 222 333"), services);

        FacilityEditCommand facilityEditCommand = new FacilityEditCommand(facility2, editedFacility);

        List<Facility> facilitiesList = new ArrayList<>();
        facilitiesList.add(facility1);

        Facilities facilities = Mockito.mock(Facilities.class);

        // when/then

        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        assertThatThrownBy(() -> testObj.edit(facilityEditCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility " + facility2.getName() + " not found ");
    }

    @Test
    @DisplayName("Should not edit facility when already exists")
    void shouldNotEditWhenEditedFacilityAlreadyExists() {

        // given

        List<Service> services = getFacilityServices();

        Facility facility1 = new Facility(
                2,
                "facility1",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        Facility facility2 = new Facility(
                2,
                "facility2",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123"),
                services
        );

        Facility editedFacility = new Facility(
                1,
                "edited_facility",
                new Address("Gdańsk-updated", "Kolejowa 24", "+48 111 222 333"),
                services
        );

        FacilityEditCommand facilityEditCommand = new FacilityEditCommand(facility2, editedFacility);

        List<Facility> facilitiesList = new ArrayList<>();
        facilitiesList.add(facility1);
        facilitiesList.add(facility2);
        facilitiesList.add(editedFacility);

        Facilities facilities = Mockito.mock(Facilities.class);

        // when/then

        Mockito.when(facilities.getFacilities()).thenReturn(facilitiesList);
        Mockito.when(facilitiesReadModelDbRepository.getAll()).thenReturn(facilities);

        assertThatThrownBy(() -> testObj.edit(facilityEditCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility " + editedFacility.getName() + " already exists ");
    }

    private static List<Service> getFacilityServices() {
        List<Service> services = new ArrayList<>();
        services.add(new Service("wspomaganie-1"));
        services.add(new Service("wspomaganie-2"));
        services.add(new Service("wspomaganie-3"));
        return services;
    }

}