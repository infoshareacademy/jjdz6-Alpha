package com.infoshare.alpha.wwr.domain.facilities.common;

import java.io.IOException;

public class FacilitiesException extends IOException {

    public static final int FACILITY_NOT_FOUND_ERROR_CODE = 10000;
    public static final int FACILITY_EXISTS_ERROR_CODE = 10001;

    private String message;
    private int code;

    public FacilitiesException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public static FacilitiesException facilityNotFound(String name) {

        return new FacilitiesException("Facility " + name + " not found ", FacilitiesException.FACILITY_NOT_FOUND_ERROR_CODE);
    }

    public static FacilitiesException facilityExists(String name) {

        return new FacilitiesException("Facility " + name + " already exists ", FacilitiesException.FACILITY_EXISTS_ERROR_CODE);
    }
}
