package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

/**
 * @author pkowerzanow
 */
public class FacilityAddCommand extends FacilityCommand {

    // klasa polecenie - command która bedzie parametrem serwisu podczas dodawania nowej placowki

    public FacilityAddCommand(Facility facility) {
        super(facility);
    }

    public FacilityAddCommand(String name, String city, String street, String phone) {
        Address address = new Address(city, street, phone);
        Facility facility = new Facility(name, address);
        this.set(facility);
    }

}
