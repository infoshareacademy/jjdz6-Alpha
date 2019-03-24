package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.utils.Menu.MainMenu;

public class InputForms {

    public static Patient getPatientFromKeyboard() throws PeselException {

        System.out.println("Enter patient name: ");
        String name = MainMenu.getConsoleStringInput();

        System.out.println("Enter pateitn surname: ");
        String surname = MainMenu.getConsoleStringInput();


        Pesel pesel = InputForms.getPeselFromKeyboard();
        Address address = InputForms.getAddressFromKeyboard();

        return new Patient(name, surname, pesel, address);
    }

    public static Facility getFacilityFromKeyboard() {
        System.out.println("Enter facility name: ");
        String name = MainMenu.getConsoleStringInput();
        Address address = InputForms.getAddressFromKeyboard();

        return new Facility(name, address);
    }

    public static Address getAddressFromKeyboard() {

        System.out.println("Enter city: ");
        String city = MainMenu.getConsoleStringInput();

        System.out.println("Enter street: ");
        String street = MainMenu.getConsoleStringInput();

        System.out.println("Enter phone: ");
        String phone = MainMenu.getConsoleStringInput();

        return new Address(city, street, phone);
    }


    public static Pesel getPeselFromKeyboard() throws PeselException {
        System.out.println("Enter pesel number: ");
        String peselNumber = MainMenu.getConsoleStringInput();

        return new Pesel(peselNumber);
    }

}
