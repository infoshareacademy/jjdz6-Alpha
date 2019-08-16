package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.entities.Parent;
import com.infoshare.alpha.wwr.entities.Patient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatientTest {

    private static Pesel givenPesel;
    private final Patient testObj = new Patient("TestName", "TestSurname", givenPesel, new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname"));

    @BeforeAll
    static void setGivenPesel() {
        try {
            givenPesel = new Pesel("99999999999");
        } catch (PeselException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should return 0")
    void shouldEquals() {
        // given
        Patient givenPatient = new Patient("TestName", "TestSurname", givenPesel, new Address("TestCity", "TestStreet", "123 456 789", 80000), new Parent("TestParentName", "TestParentSurname"));

        // when
        int result = testObj.compareTo(givenPatient);

        // then
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("Should not return 0")
    void shouldNotEquals() {
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
}