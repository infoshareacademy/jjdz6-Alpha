package com.infoshare.alpha.wwr.servlet.validators;

import javax.enterprise.context.RequestScoped;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class FacilityServletValidator {

    private final String[] requiredFacilityFields = {"facility_id", "facility_name", "facility_address_city", "facility_address_street", "facility_address_phone", "service[]", "_method"};

    public void validatePutRequest(Map<String, String[]> requestData) throws FacilityValidationException{
        this.validateRequiredFields(requestData.keySet());
        this.validateId(requestData.get("facility_id")[0]);
        this.validateName(requestData.get("facility_name")[0]);
        this.validateCity(requestData.get("facility_address_city")[0]);
        this.validateStreet(requestData.get("facility_address_street")[0]);
        this.validatePhone(requestData.get("facility_address_phone")[0]);
        this.validateServices(requestData.get("service[]"));
    }

    private void validateServices(String[] services) throws FacilityValidationException {
        if (services.length == 0) {
            throw FacilityValidationException.services();
        }

        for(String service : services) {
            if (service.isEmpty()) {
                throw FacilityValidationException.services();
            }
        }
    }

    private void validateRequiredFields(Set<String> keySet) throws FacilityValidationException {
        Set<String> requiredKeys = Arrays.stream(this.requiredFacilityFields).collect(Collectors.toSet());

        if (!keySet.containsAll(requiredKeys)) {
            throw FacilityValidationException.keys();
        }
    }

    private void validateId(String facilityId) throws FacilityValidationException {
        if (facilityId == null) {
            throw FacilityValidationException.id();
        }

        try {
            Integer.valueOf(facilityId);
        }
        catch (NumberFormatException e) {
            throw FacilityValidationException.id();
        }
    }

    private void validateStreet(String street) throws FacilityValidationException {
        if (street == null) {
            throw FacilityValidationException.street();
        }

        if (street.isEmpty()) {
            throw FacilityValidationException.street();
        }
    }

    private void validateCity(String city) throws FacilityValidationException {
        if (city == null) {
            throw FacilityValidationException.city();
        }

        if (city.isEmpty()) {
            throw FacilityValidationException.city();
        }
    }

    private void validatePhone(String phone) throws FacilityValidationException {
        if (phone == null) {
            throw FacilityValidationException.phone();
        }

        if (phone.isEmpty()) {
            throw FacilityValidationException.phone();
        }
    }

    private void validateName(String name) throws FacilityValidationException {

        if (name == null) {
            throw FacilityValidationException.name();
        }

        if (name.isEmpty()) {
            throw FacilityValidationException.name();
        }
    }
}
