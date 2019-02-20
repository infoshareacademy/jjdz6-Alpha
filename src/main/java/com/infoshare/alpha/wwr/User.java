package com.infoshare.alpha.wwr;

import java.math.BigInteger;

public abstract class User {

    private String name;

    private String surname;

    private BigInteger pesel;

    public User(String name, String surname, BigInteger pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public User() {
        this.name = "";
        this.surname = "";
        this.pesel = "";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigInteger getPesel() {
        return pesel;
    }
}
