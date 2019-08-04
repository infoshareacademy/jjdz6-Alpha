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

        Facility facility1 = new Facility(
                1,
                "old_facility",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123", 80800),
                getFacilityServices()
        );

        FacilityAddCommand facilityAddCommand = new FacilityAddCommand(facility1);

        // when

        Mockito.when(facilitiesReadModelDbRepository.getById(facilityAddCommand.getFacility().getId())).thenReturn(null);

        try {
            testObj.add(facilityAddCommand);
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        // then

        Mockito.verify(facilitiesReadModelDbRepository, Mockito.times(1)).getById(1);
    }

    @Test
    @DisplayName("Should not add facility when facility already exists")
    void shouldNotAddWhenFacilityAlreadyExists() {

        // given

        Facility facility1 = new Facility(
                1,
                "old_facility",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123", 80800),
                getFacilityServices()
        );

        FacilityAddCommand facilityAddCommand = new FacilityAddCommand(facility1);

        // when/then


        Mockito.when(facilitiesReadModelDbRepository.getById(facilityAddCommand.getFacility().getId())).thenReturn(facility1);

        assertThatThrownBy(() -> testObj.add(facilityAddCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility " + facility1.getName() + " already exists ");

    }

    @Test
    @DisplayName("Should delete facility")
    void shouldDeleteFacility() {

        // given

        Facility facility1 = new Facility(
                1,
                "facility-1",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123", 80800),
                getFacilityServices()
        );

        // when

        Mockito.when(facilitiesReadModelDbRepository.getById(facility1.getId())).thenReturn(facility1);
        FacilityDeleteCommand facilityDeleteCommand = new FacilityDeleteCommand(facility1);

        try {
            testObj.delete(facilityDeleteCommand);
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        // then

        Mockito.verify(facilitiesDbRepository, Mockito.times(1)).remove(facility1);
    }

    @Test
    @DisplayName("Should not delete facility while not exist.")
    void shouldNotDeleteFacilityWhileNotExist() {

        // given

        Facility facility1 = new Facility(
                1,
                "facility-1",
                new Address("Gdańsk", "Kolejowa 23", "+48 123 123 123", 80800),
                getFacilityServices()
        );


        FacilityDeleteCommand facilityDeleteCommand = new FacilityDeleteCommand(facility1);

        // when/then

        Mockito.when(facilitiesReadModelDbRepository.getById(facility1.getId())).thenReturn(null);

        assertThatThrownBy(() -> testObj.delete(facilityDeleteCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility " + facility1.getName() + " not found ");

    }

    @Test
    @DisplayName("Should edit facility")
    void shouldEdit() throws FacilitiesException {

        // given

        List<Service> services = getFacilityServices();
        Facility editedFacility = new Facility(
                1,
                "edited_facility",
                new Address("Gdańsk-updated", "Kolejowa 24", "+48 111 222 333", 80800),
                true,
                services
        );

        FacilityEditCommand facilityEditCommand = new FacilityEditCommand(editedFacility);

        // when

        Mockito.when(facilitiesDbRepository.getById(editedFacility.getId())).thenReturn(editedFacility);
        Mockito.when(facilitiesDbRepository.update(editedFacility)).thenReturn(editedFacility);

        try {
            testObj.edit(facilityEditCommand);
        } catch (FacilitiesException e) {
            e.printStackTrace();
        }

        // then

        Mockito.verify(facilitiesDbRepository, Mockito.times(1)).getById(editedFacility.getId());
        Mockito.verify(facilitiesDbRepository, Mockito.times(1)).update(editedFacility);
    }

    @Test
    @DisplayName("Should not edit facility when not found in source")
    void shouldNotEditFacilityWhenNotFound() throws FacilitiesException {

        // given

        List<Service> services = getFacilityServices();
        Facility editedFacility = new Facility(
                1,
                "edited_facility",
                new Address("Gdańsk-updated", "Kolejowa 24", "+48 111 222 333", 80800),
                true,
                services
        );

        FacilityEditCommand facilityEditCommand = new FacilityEditCommand(editedFacility);

        // when/then

        Mockito.when(facilitiesDbRepository.getById(editedFacility.getId())).thenThrow(FacilitiesException.facilityNotFound());

        assertThatThrownBy(() -> testObj.edit(facilityEditCommand))
                .isInstanceOf(FacilitiesException.class)
                .hasMessage("Facility edit error: " + "Facility not found.");
    }

    private static List<Service> getFacilityServices() {
        List<Service> services = new ArrayList<>();
        services.add(new Service("wspomaganie-1"));
        services.add(new Service("wspomaganie-2"));
        services.add(new Service("wspomaganie-3"));
        return services;
    }

}