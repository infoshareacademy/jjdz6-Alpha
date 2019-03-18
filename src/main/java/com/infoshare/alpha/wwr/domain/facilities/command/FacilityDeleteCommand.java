package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

public class FacilityDeleteCommand extends FacilityCommand {

    public FacilityDeleteCommand(Facility facility) {
        super(facility);
    }

    public FacilityDeleteCommand(String name, String city, String street, String phone) {
        Address address = new Address(city,street, phone);
        Facility facility = new Facility(name, address);
        this.set(facility);
    }
}
