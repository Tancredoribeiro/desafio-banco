package com.br.desafio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SaldoInsufucienteException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public SaldoInsufucienteException(String message) {
        super(message);
    }
    
    
    
    

}
