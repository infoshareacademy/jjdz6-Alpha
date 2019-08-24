package com.infoshare.alpha.wwr.servlet.validators;

public class PatientValidationException extends Throwable {

    public static final String PATIENT_NAME_VALIDATION_ERROR_MSG = "Name validation error";
    public static final int PATIENT_NAME_VALIDATION_ERROR_CODE = 2000;

    public static final String PATIENT_SURNAME_VALIDATION_ERROR_MSG = "Surname validation error";
    public static final int PATIENT_SURNAME_VALIDATION_ERROR_CODE = 2001;

    public static final String PATIENT_PESEL_VALIDATION_ERROR_MSG = "Pesel validation error";
    public static final int PATIENT_PESEL_VALIDATION_ERROR_CODE = 2002;

    public static final String PATIENT_STREET_VALIDATION_ERROR_MSG = "Street validation error";
    public static final int PATIENT_STREET_VALIDATION_ERROR_CODE = 2003;

    public static final String PATIENT_CITY_VALIDATION_ERROR_MSG = "City validation error.";
    public static final int PATIENT_CITY_VALIDATION_ERROR_CODE = 2004;

    public static final String PATIENT_PHONE_VALIDATION_ERROR_MSG = "Phone validation error";
    public static final int PATIENT_PHONE_VALIDATION_ERROR_CODE = 2005;

    private static final String PATIENT_POSTAL_VALIDATION_ERROR_MSG = "Postal code validation error.";
    private static final int PATIENT_POSTAL_VALIDATION_ERROR_CODE = 2006;

    private static final String PATIENT_CARETAKER_NAME_VALIDATION_ERROR_MSG = "Caretaker name code validation error.";
    private static final int PATIENT_CARETAKER_NAME_VALIDATION_ERROR_CODE = 2007;

    private static final String PATIENT_CARETAKER_SURNAME_VALIDATION_ERROR_MSG = "Caretaker surname code validation error.";
    private static final int PATIENT_CARETAKER_SURNAME_VALIDATION_ERROR_CODE = 2008;

    public static final String PATIENT_KEYS_VALIDATION_ERROR_MSG = "Request keys are invalid";
    public static final int PATIENT_KEYS_VALIDATION_ERROR_CODE = 2009;



    private final String message;

    private final int code;


    public PatientValidationException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static PatientValidationException name() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_NAME_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_NAME_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException surname() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_SURNAME_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_SURNAME_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException pesel() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_PESEL_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_PESEL_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException street() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_STREET_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_STREET_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException city() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_CITY_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_CITY_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException phone() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_PHONE_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_PHONE_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException postal() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_POSTAL_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_POSTAL_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException caretakerName() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_CARETAKER_NAME_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_CARETAKER_NAME_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException caretakerSurname() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_CARETAKER_SURNAME_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_CARETAKER_SURNAME_VALIDATION_ERROR_CODE
        );
    }

    public static PatientValidationException keys() {
        return new PatientValidationException(
                PatientValidationException.PATIENT_KEYS_VALIDATION_ERROR_MSG,
                PatientValidationException.PATIENT_KEYS_VALIDATION_ERROR_CODE
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
