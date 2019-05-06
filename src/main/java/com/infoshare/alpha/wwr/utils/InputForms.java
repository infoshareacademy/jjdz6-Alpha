package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.patients.entity.Parent;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class InputForms {

    public static Patient getPatientFromKeyboard() throws PeselException {

        System.out.println("Enter patient name: ");
        String name = Menu.getConsoleStringInput();

        System.out.println("Enter patient surname: ");
        String surname = Menu.getConsoleStringInput();


        Pesel pesel = InputForms.getPeselFromKeyboard();
        Address address = InputForms.getAddressFromKeyboard();

        Parent parent = InputForms.getParentFromKeyboard();


        return new Patient(name, surname, pesel, address, parent);
    }



    public static Facility getFacilityFromKeyboard() {
        System.out.println("Enter facility name: ");
        String name = Menu.getConsoleStringInput();
        Address address = InputForms.getAddressFromKeyboard();
        List<Service> services = InputForms.getServicesFromKeyboard();

        return new Facility(name, address, services);
    }

    public static Facility getEditedFacilityFromKeyboard(Facility facilityToBeEdited){
        System.out.println("Enter facility's new name or press 'ENTER' to keep the existing name:");
        String editedFacilityName = Menu.getConsoleStringInput();
        if(editedFacilityName.equals("")){
            editedFacilityName = facilityToBeEdited.getName();
        }
        Address editedFacilityAddress = InputForms.getEditedAddressFromKeyboard(facilityToBeEdited.getAddress());
        List<Service> editedServices = InputForms.getServicesFromKeyboard();
        if(editedServices.isEmpty()){
            editedServices = facilityToBeEdited.getServices();
            System.out.println("Facility services have not been changed.");
        }
        return new Facility(editedFacilityName, editedFacilityAddress, facilityToBeEdited.getId(), editedServices);
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

    public static List<Service> getServicesFromKeyboard(){
        System.out.println("Enter next service name and press 'ENTER'");
        System.out.println("In order to leave this entry, press 'x' and 'ENTER'.");
        List<Service> services = new ArrayList<>();
        String userInput = Menu.getConsoleStringInput();
        while(!userInput.equals("x")){
            System.out.println("Enter next service name and press 'ENTER'");
            System.out.println("In order to leave this entry, press 'x' and 'ENTER'.");
            services.add(new Service(userInput));
            userInput = Menu.getConsoleStringInput();
        }
        return services;
    }

    private static Parent getParentFromKeyboard() {
        System.out.println("Enter parent name: ");
        String nameCaretaker = Menu.getConsoleStringInput();

        System.out.println("Enter parent surname: ");
        String surnameCaretaker = Menu.getConsoleStringInput();

        return new Parent(nameCaretaker, surnameCaretaker);
    }

    public static Address getEditedAddressFromKeyboard(Address address){
        System.out.println("Current city is: " + address.getCity());
        System.out.println("Enter new city or press 'ENTER' to keep the existing city");
        String newCity = Menu.getConsoleStringInput();
        if(newCity.equals("")){
            newCity = address.getCity();
        }
        System.out.println("Current street is: " + address.getStreet());
        System.out.println("Enter new street or press 'ENTER' to keep the existing street");
        String newStreet = Menu.getConsoleStringInput();
        if(newStreet.equals("")){
            newStreet = address.getStreet();
        }
        System.out.println("Current phone is: " + address.getPhone());
        System.out.println("Enter new phone or press 'ENTER' to keep the existing phone");
        String newPhone = Menu.getConsoleStringInput();
        if(newPhone.equals("")){
            newPhone = address.getPhone();
        }

        return new Address(newCity, newStreet, newPhone);
    }


    public static Pesel getPeselFromKeyboard() throws PeselException {
        System.out.println("Enter pesel number: ");
        String peselNumber = Menu.getConsoleStringInput();

        return new Pesel(peselNumber);
    }

}
