package com.infoshare.alpha.wwr.common;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostalCodeComparatorTest {

    private PostalCodeComparator testObj;
    private final List<Service> givenServicesList = Collections.singletonList(new Service("TestService"));
    private final Facility givenFacility1 = new Facility(1, "TestFacility1", new Address("TestCity", "TestStreet", "123 456 789", 80001), givenServicesList);
    private final Facility givenFacility2 = new Facility(2, "TestFacility2", new Address("TestCity2", "TestStreet2", "987 654 321", 80003), givenServicesList);


    @Test
    @DisplayName("Should return -1")
    void shouldComparePostalCode() {
        // given
        testObj = new PostalCodeComparator(80000);

        // when
        int result = testObj.compare(givenFacility1, givenFacility2);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Should return 1")
    void shouldCompareSmallerCode() {
        // given
        testObj = new PostalCodeComparator(80004);

        // when
        int result = testObj.compare(givenFacility1, givenFacility2);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Should return 0")
    void shouldCompareEqualCode() {
        // given
        testObj = new PostalCodeComparator(80002);

        // when
        int result = testObj.compare(givenFacility1, givenFacility2);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should sort list based on postal code in ascending order")
    void sortListBasedOnPostalCode() {
        // given
        testObj = new PostalCodeComparator(80003);
        Facility givenFacility3 = new Facility(3, "TestFacility3", new Address("TestCity3", "TestStreet3", "987 654 321", 80004), givenServicesList);
        List<Facility> givenFacilitiesList = Arrays.asList(givenFacility1, givenFacility2, givenFacility3);

        // when
        givenFacilitiesList.sort(testObj);

        // then
        assertThat(givenFacilitiesList)
                .containsExactly(givenFacility2, givenFacility3, givenFacility1);
    }
}