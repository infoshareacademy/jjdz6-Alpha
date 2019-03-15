package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

public class InputForms {

    public static Patient getPatientFromKeyboard() throws PeselException {

        System.out.println("Enter patient name: ");
        String name = Menu.getConsoleStringInput();

        System.out.println("Enter pateitn surname: ");
        String surname = Menu.getConsoleStringInput();


        Pesel pesel = InputForms.getPeselFromKeyboard();
        Address address = InputForms.getAddressFromKeyboard();

        return new Patient(name, surname, pesel, address);
    }

    public static Address getAddressFromKeyboard() {

        System.out.println("Enter city: ");
        String city = Menu.getConsoleStringInput();

        System.out.println("Enter street: ");
        String street = Menu.getConsoleStringInput();

        System.out.println("Enter phone: ");
        String phone = Menu.getConsoleStringInput();

        return new Address(city, street, phone);
    }


    public static Pesel getPeselFromKeyboard() throws PeselException {
        System.out.println("Enter pesel number: ");
        String peselNumber = Menu.getConsoleStringInput();

        return new Pesel(peselNumber);
    }

}
