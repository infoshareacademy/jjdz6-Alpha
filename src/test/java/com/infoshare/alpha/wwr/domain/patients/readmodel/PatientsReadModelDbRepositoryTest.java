package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.patients.dao.PatientDao;
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

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PatientsReadModelDbRepositoryTest {

    @Mock
    private PatientDao patientDao;

    @InjectMocks
    private PatientsReadModelDbRepository testObj;

    private Map<PatientQueryFields, String> givenPatientQueryFieldsMap = new EnumMap<>(PatientQueryFields.class);

    @Test
    @DisplayName("Should return only 1 Patient with surname matching query")
    void getOnePatientByQueryFieldSurname() throws PeselException {
        // given
        givenPatientQueryFieldsMap.put(PatientQueryFields.SURNAME, "Jankowski");
        PatientQuery givenPatientQuery = new PatientQuery(givenPatientQueryFieldsMap);

        Mockito.when(patientDao.findAll()).thenReturn(getPatients());

        // when
        Patients result = testObj.getByQuery(givenPatientQuery);

        // then
        Mockito.verify(patientDao).findAll();
        assertThat(result.getPatients()).hasSize(1);
        assertThat(result.getPatients().get(0).getSurname().equals("Jankowski")).isTrue();
    }


    @Test
    @DisplayName("Should return all Patients with surname matching query")
    void getSeveralPatientsByQueryFieldSurname() throws PeselException {
        // given
        givenPatientQueryFieldsMap.put(PatientQueryFields.SURNAME, "Łukaszewski");
        PatientQuery givenPatientQuery = new PatientQuery(givenPatientQueryFieldsMap);
        Mockito.when(patientDao.findAll()).thenReturn(getPatients());

        // when
        Patients result = testObj.getByQuery(givenPatientQuery);

        // then
        Mockito.verify(patientDao).findAll();
        assertThat(result.getPatients()).hasSize(2);
        assertThat(result.getPatients().stream().allMatch(patient -> patient.getSurname().equals("Łukaszewski"))).isTrue();
    }

    @Test
    @DisplayName("Should return object of type Patients containing empty list for query not matching any surname")
    void getEmptyListForQueryFieldSurnameNotMatchingAnyPatient() throws PeselException {
        // given
        givenPatientQueryFieldsMap.put(PatientQueryFields.SURNAME, "Kowalski");
        PatientQuery givenPatientQuery = new PatientQuery(givenPatientQueryFieldsMap);
        Mockito.when(patientDao.findAll()).thenReturn(getPatients());

        // when
        Patients result = testObj.getByQuery(givenPatientQuery);

        // then
        Mockito.verify(patientDao).findAll();
        assertThat(result.getPatients()).isEmpty();
    }

    private static List<Patient> getPatients() throws PeselException {
        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient("TestName", "Jankowski", new Pesel("12345678909"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
        patients.add(new Patient("TestName", "Łukaszewski", new Pesel("23456789012"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
        patients.add(new Patient("TestName", "Łukaszewski", new Pesel("45678901234"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));
        patients.add(new Patient("TestName", "Nowak", new Pesel("99876543212"), new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname")));

        return patients;
    }
}