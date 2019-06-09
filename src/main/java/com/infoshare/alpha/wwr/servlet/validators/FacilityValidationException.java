package com.infoshare.alpha.wwr.servlet.validators;

public class FacilityValidationException extends Throwable {

    public static final String FACILITY_ID_VALIDATION_ERROR_MSG = "Id missing error.";
    public static final int FACILITY_ID_VALIDATION_ERROR_CODE = 1000;

    public static final String FACILITY_NAME_VALIDATION_ERROR_MSG = "Name validation error";
    public static final int FACILITY_NAME_VALIDATION_ERROR_CODE = 1001;

    public static final String FACILITY_CITY_VALIDATION_ERROR_MSG = "City validation error.";
    public static final int FACILITY_CITY_VALIDATION_ERROR_CODE = 1002;

    public static final String FACILITY_STREET_VALIDATION_ERROR_MSG = "Street validation error";
    public static final int FACILITY_STREET_VALIDATION_ERROR_CODE = 1003;

    public static final String FACILITY_PHONE_VALIDATION_ERROR_MSG = "Phone validation error";
    public static final int FACILITY_PHONE_VALIDATION_ERROR_CODE = 1004;

    public static final String FACILITY_KEYS_VALIDATION_ERROR_MSG = "Request keys are invalid";
    public static final int FACILITY_KEYS_VALIDATION_ERROR_CODE = 1005;

    private static final String FACILITY_SERVICES_VALIDATION_ERROR_MSG = "Services validation error.";
    private static final int FACILITY_SERVICES_VALIDATION_ERROR_CODE = 1006;

    private static final String FACILITY_POSTAL_VALIDATION_ERROR_MSG = "Postal code validation error.";
    private static final int FACILITY_POSTAL_VALIDATION_ERROR_CODE = 1007;

    private final String message;

    private final int code;

    private FacilityValidationException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static FacilityValidationException id() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_ID_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_ID_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException name() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_NAME_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_NAME_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException city() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_CITY_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_CITY_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException street() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_STREET_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_STREET_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException phone() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_PHONE_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_PHONE_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException keys() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_KEYS_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_KEYS_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException services() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_SERVICES_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_SERVICES_VALIDATION_ERROR_CODE
        );
    }

    public static FacilityValidationException postal() {
        return new FacilityValidationException(
                FacilityValidationException.FACILITY_POSTAL_VALIDATION_ERROR_MSG,
                FacilityValidationException.FACILITY_POSTAL_VALIDATION_ERROR_CODE
        );
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
