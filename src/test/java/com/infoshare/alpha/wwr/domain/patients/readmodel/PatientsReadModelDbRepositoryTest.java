package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQueryFields;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PatientsReadModelDbRepositoryTest {
//TODO: testy do poprawy
    @Mock
    private PatientsJsonStorage storage;
    @InjectMocks
    private PatientsReadModelDbRepository testObj;

    private Map<PatientQueryFields, String> givenPatientQueryFieldsMap = new EnumMap<>(PatientQueryFields.class);


    @DisplayName("Should return only 1 Patient with surname matching query")
    void getOnePatientByQueryFieldSurname() {
        // given
        givenPatientQueryFieldsMap.put(PatientQueryFields.SURNAME, "Jankowski");
        PatientQuery givenPatientQuery = new PatientQuery(givenPatientQueryFieldsMap);
        Mockito.when(storage.load()).thenReturn(getPatients());

        // when
        Patients result = testObj.getByQuery(givenPatientQuery);

        // then
        Mockito.verify(storage).load();
        assertThat(result.getPatients()).hasSize(1);
        assertThat(result.getPatients().get(0).getSurname().equals("Jankowski")).isTrue();
    }


    @DisplayName("Should return all Patients with surname matching query")
    void getSeveralPatientsByQueryFieldSurname() {
        // given
        givenPatientQueryFieldsMap.put(PatientQueryFields.SURNAME, "Łukaszewski");
        PatientQuery givenPatientQuery = new PatientQuery(givenPatientQueryFieldsMap);
        Mockito.when(storage.load()).thenReturn(getPatients());

        // when
        Patients result = testObj.getByQuery(givenPatientQuery);

        // then
        Mockito.verify(storage).load();
        assertThat(result.getPatients()).hasSize(2);
        assertThat(result.getPatients().stream().allMatch(patient -> patient.getSurname().equals("Łukaszewski"))).isTrue();
    }


    @DisplayName("Should return object of type Patients containing empty list for query not matching any surname")
    void getEmptyListForQueryFieldSurnameNotMatchingAnyPatient() {
        // given
        givenPatientQueryFieldsMap.put(PatientQueryFields.SURNAME, "Kowalski");
        PatientQuery givenPatientQuery = new PatientQuery(givenPatientQueryFieldsMap);
        Mockito.when(storage.load()).thenReturn(getPatients());

        // when
        Patients result = testObj.getByQuery(givenPatientQuery);

        // then
        Mockito.verify(storage).load();
        assertThat(result.getPatients()).isEmpty();
    }

    private static Patients getPatients() {
        Patients givenPatients = new Patients();
        try {
            givenPatients.add(new Patient("TestName", "Jankowski", new Pesel("12345678909"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
            givenPatients.add(new Patient("TestName", "Łukaszewski", new Pesel("23456789012"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
            givenPatients.add(new Patient("TestName", "Łukaszewski", new Pesel("45678901234"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
            givenPatients.add(new Patient("TestName", "Nowak", new Pesel("99876543212"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
        } catch (PeselException e) {
            e.printStackTrace();
        }
        return givenPatients;
    }
}