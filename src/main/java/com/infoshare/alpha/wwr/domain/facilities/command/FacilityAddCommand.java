package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pkowerzanow
 */
public class FacilityAddCommand extends FacilityCommand {

    public FacilityAddCommand(Facility facility) {
        super(facility);
    }

    public FacilityAddCommand(String name, String city, String street, String phone, Integer postalCode, Boolean isNfz, String[] services) {
        Address address = new Address(city, street, phone, postalCode);
        List<Service> serviceList = Arrays.stream(services).map(Service::new).collect(Collectors.toList());
        Facility facility = new Facility(name, address, isNfz, serviceList);
        this.set(facility);
    }
}
