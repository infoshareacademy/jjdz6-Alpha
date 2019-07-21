package com.infoshare.alpha.wwr.common;

import javax.persistence.*;

@Entity
@Table(name = "pesel_numbers")
public class Pesel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number", nullable = false)
    private String number;

    public Pesel() {
    }

    public Pesel(String number) throws PeselException {
        if (number.length() != 11) {

            throw PeselException.validationError();
        }
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getPesel() {
        return number;
    }

    @Override
    public String toString() {
        return " Pesel = " + number;
    }
}
