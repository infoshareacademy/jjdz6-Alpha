package com.infoshare.alpha.wwr.common;

public class Pesel {

    private String pesel;

    public Pesel(String pesel) {
        // mozna dorobic walidacje
        if (pesel.length() != 11) {
            // rzuc wyjatek
            System.out.println("Pesel niepoprawny");
        }
        this.pesel = pesel;
    }

    public String getPesel() {

        return pesel;
    }

    @Override
    public String toString() {
        return "Pesel{" +
                "pesel='" + pesel + '\'' +
                '}';
    }
}
