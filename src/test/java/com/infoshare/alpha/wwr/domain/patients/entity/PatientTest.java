package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatientTest {

    private Pesel givenPesel;

    {
        try {
            givenPesel = new Pesel("99999999999");
        } catch (PeselException e) {
            e.printStackTrace();
        }
    }

    private final Patient testObj = new Patient("TestName", "TestSurname", givenPesel, new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname"));

    @Test
    @DisplayName("Should not return 0 when surname is different")
    void comparePatientsWithDifferentSurname() {
        // given
        Patient givenPatient = new Patient("TestName", "GivenSurname", givenPesel, new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname"));

        // when
        int result = testObj.compareTo(givenPatient);

        // then
        assertThat(result).isNotZero();
    }

    @Test
    @DisplayName("Should not return 0 when name is different")
    void comparePatientsWithDifferentName() {
        // given
        Patient givenPatient = new Patient("GivenName", "TestSurname", givenPesel, new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname"));

        // when
        int result = testObj.compareTo(givenPatient);

        // then
        assertThat(result).isNotZero();
    }

    @Test
    @DisplayName("Should not return 0 when Pesel is different")
    void comparePatientsWithDifferentPesel() {
        // given
        Pesel givenPesel2 = null;
        try {
            givenPesel2 = new Pesel("11111111111");
        } catch (PeselException e) {
            e.printStackTrace();
        }
        Patient givenPatient = new Patient("TestName", "TestSurname", givenPesel2, new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname"));

        // when
        int result = testObj.compareTo(givenPatient);

        // then
        assertThat(result).isNotZero();
    }

    @Test
    @DisplayName("Should return 0 when Surname, Name and Pesel are equal")
    void comparePatientsWithSameSurnameNameAndPesel() {
        // given
        Patient givenPatient = new Patient("TestName", "TestSurname", givenPesel, new Address("GivenCity", "GivenStreet", "987 654 321", 80200), new Parent("GivenParentName", "GivenParentSurname"));

        // when
        int result = testObj.compareTo(givenPatient);

        // then
        assertThat(testObj.getName()).isEqualTo(givenPatient.getName());
        assertThat(testObj.getSurname()).isEqualTo(givenPatient.getSurname());
        assertThat(testObj.getPesel()).isEqualTo(givenPatient.getPesel());
        assertThat(result).isEqualTo(0);
    }
}