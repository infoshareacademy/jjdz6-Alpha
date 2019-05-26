package com.infoshare.alpha.wwr.servlet.validators;

public class FacilityValidationException extends Throwable {


    public static final int FACILITY_EMPTY_NAME_ERROR_CODE = 1000;
    public static final String FACILITY_EMPTY_NAME_ERROR_MSG = "Empty facility name.";

    private String message;

    private  int code;

    private FacilityValidationException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static FacilityValidationException emptyName() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_EMPTY_NAME_ERROR_MSG,
                FacilityValidationException.FACILITY_EMPTY_NAME_ERROR_CODE
        );
    }

}
