package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FacilitiesReadModelDbRepositoryTest {

    @Mock
    private FacilitiesJsonStorage storage;
    @InjectMocks
    private FacilitiesReadModelDbRepository testObj;

    @Test
    @DisplayName("Should return list of facilities sorted based on the difference to the given patients' postal code in ascending order")
    void getByPatient() {
        // given
        Pesel givenPesel = null;
        try {
            givenPesel = new Pesel("12345678909");
        } catch (PeselException e) {
            e.printStackTrace();
        }
        Patient givenPatient = new Patient("TestName", "Jankowski", givenPesel, new Address("TestCity", "TestStreet", "123 456 789", 80300), new Parent("TestParentName", "TestParentSurname"));
        FacilityPatientQuery givenFacilityPatientQuery = new FacilityPatientQuery(givenPatient, Collections.singletonList(FacilityQueryField.POSTAL_CODE));
        Mockito.when(storage.load()).thenReturn(getFacilitiesList());

        // when
        List<Facility> result = testObj.getByPatient(givenFacilityPatientQuery);

        // then
        Mockito.verify(storage).load();
        assertThat(result).hasSize(4);
        assertThat(result.get(0).getId() == 3).isTrue();
        assertThat(result.get(1).getId() == 2).isTrue();
        assertThat(result.get(2).getId() == 4).isTrue();
        assertThat(result.get(3).getId() == 1).isTrue();
    }

    private static Facilities getFacilitiesList() {
        List<Service> givenServicesList = Collections.singletonList(new Service("TestService"));

        List<Facility> givenFacilitiesList = new ArrayList<>();
        givenFacilitiesList.add(new Facility(1, "TestFacility1", new Address("TestCity", "TestStreet", "123 456 789", 80001), givenServicesList));
        givenFacilitiesList.add(new Facility(2, "TestFacility2", new Address("TestCity", "TestStreet", "123 456 789", 80292), givenServicesList));
        givenFacilitiesList.add(new Facility(3, "TestFacility3", new Address("TestCity", "TestStreet", "123 456 789", 80303), givenServicesList));
        givenFacilitiesList.add(new Facility(4, "TestFacility4", new Address("TestCity", "TestStreet", "123 456 789", 80393), givenServicesList));

        Facilities givenFacilities = new Facilities();
        givenFacilities.setFacilities(givenFacilitiesList);
        return givenFacilities;
    }
}