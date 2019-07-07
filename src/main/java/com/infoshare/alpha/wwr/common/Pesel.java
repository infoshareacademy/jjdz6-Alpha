package com.infoshare.alpha.wwr.common;

import javax.persistence.*;

@Entity
@Table(name = "pesel_numbers")
public class Pesel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pesel")
    private String pesel;

    public Pesel(String pesel) throws PeselException {
        if (pesel.length() != 11) {

            throw PeselException.validationError();
        }
        this.pesel = pesel;
    }

    public String getPesel() {

        return pesel;
    }

    @Override
    public String toString() {

        return " Pesel = " + pesel;
    }
}
