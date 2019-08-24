package com.infoshare.alpha.wwr.common;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PeselTest {

    @Test
    @DisplayName("Should instantiate pesel")
    void shouldInstantiate() throws PeselException {

        // given


        String peselNumber = "90121212345";

        // when/then

        IsInstanceOf.instanceOf(Pesel.class).matches(new Pesel(peselNumber));
    }

    @Test
    @DisplayName("Should not instantiate when pesel invalid")
    void shouldNotInstantiateWhenPeselInvalid() {

        // given

        String invlidPeselNumber = "1234";

        // when/then

        assertThatThrownBy(() -> new Pesel(invlidPeselNumber))
                .isInstanceOf(PeselException.class)
                .hasMessage("Błędny Pesel");
    }
}