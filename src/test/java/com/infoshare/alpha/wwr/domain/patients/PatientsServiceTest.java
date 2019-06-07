package com.infoshare.alpha.wwr.domain.patients;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDb;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PatientsServiceTest {

    @Mock
    private PatientsReadModelDb patientsReadModelDbRepository;

    @Mock
    private PatientsRepository patientsRepository;

    @InjectMocks
    private PatientsService testObj;

    @Test
    @DisplayName("Should add patient")
    void shouldAdd() {

        // given

        Patient patient = null;
        try {
            patient = new Patient(
                    "patient-name",
                    "patient-surname",
                    new Pesel("90121212345"),
                    new Address("Gdańsk", "Piwna 12/11", "+48 345 333 333"),
                    new Parent("Janina", "Kowalska")
            );
        } catch (PeselException e) {
            e.printStackTrace();
        }

        Patients patients = Mockito.mock(Patients.class);

        // when

        Mockito.when(patientsReadModelDbRepository.getAll()).thenReturn(patients);

        //then

        testObj.add(patient);

        Mockito.verify(patientsReadModelDbRepository, Mockito.times(1)).getAll();
        Mockito.verify(patients, Mockito.times(1)).add(patient);
        Mockito.verify(patientsRepository, Mockito.times(1)).add(patients);
    }
}