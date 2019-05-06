package com.infoshare.alpha.wwr.common;

import com.infoshare.alpha.wwr.utils.exceptions.PeselException;

public class Pesel {

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
    	
        return " Pesel{ " +
                "pesel='" + pesel + '\'' +
                '}';
    }
}
