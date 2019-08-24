package com.infoshare.alpha.wwr.exceptions;

import javax.ws.rs.NotFoundException;

public class ResourceNotFoundException extends NotFoundException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
