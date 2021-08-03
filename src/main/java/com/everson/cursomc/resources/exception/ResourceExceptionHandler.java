package com.everson.cursomc.resources.exception;

import com.everson.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
/*
    @ControllerAdvice - Utilizado para tratamento de exceções, porém utilizado
    em toda a aplicação. Você pode pensar neles como um interceptor orientado por anotações.

    Qualquer classe anotada com @ControllerAdvice torna-se um conselho do controlador e dentre outros
    suporta métodos de tratamento de exceções anotados com @ExceptionHandler.
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
