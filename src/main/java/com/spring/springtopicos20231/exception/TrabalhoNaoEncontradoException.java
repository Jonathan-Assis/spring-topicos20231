package com.spring.springtopicos20231.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TrabalhoNaoEncontradoException extends IllegalArgumentException {

    public TrabalhoNaoEncontradoException() {
        super();
    }

    public TrabalhoNaoEncontradoException(String message) {
        super(message);
    }

}