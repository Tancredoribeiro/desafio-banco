package com.br.desafio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class SaldoNaoEncontradaException extends RuntimeException {

    public SaldoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    private static final long serialVersionUID = 1L;

}
