package com.gestion.empleados.gestion_empleados_back.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionID = 1;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
