package com.infoshare.alpha.wwr.servlet.validators;

import java.util.Map;

public class FacilityServletValidator {


    public void doPutValidator(Map<String, String[]> reqData) {

        Map<String, String[]> parameterMap = reqData;

        this.validateName();

        String facilityId = parameterMap.get("facility_id")[0];
        String facilityName = parameterMap.get("facility_name")[0];
        String facilityAddressCity = parameterMap.get("facility_address_city")[0];
        String facilityAddressStreet = parameterMap.get("facility_address_street")[0];
        String[] services = parameterMap.get("service[]");


        parameterMap.keySet().stream().forEach(k -> {logger.severe(k);});
        logger.severe("Facility name: " + facilityName);
        parameterMap.forEach((k,v)->{
            logger.severe("Key :" + k + " Value: " + v.toString());
        });
    }

    private void validateName(Object name) throws FacilityValidationException {

        if (name == null) {
            throw FacilityValidationException.emptyName();
        }

        String nameTmp = String.valueOf(name);
        if () {
            throw FacilityValidationException.emptyName();
        }

    }

}
