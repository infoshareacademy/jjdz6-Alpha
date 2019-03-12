package com.infoshare.alpha.wwr.common;

public class PeselException extends Throwable {

	private static final long serialVersionUID = 1L;
	
    public static final int PESEL_VALIDATION_ERROR_CODE = 2000;

    private String message;
    private int code;

    public PeselException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public static PeselException validationError() {

        return new PeselException("Pesel not valid", PeselException.PESEL_VALIDATION_ERROR_CODE);
    }

}
