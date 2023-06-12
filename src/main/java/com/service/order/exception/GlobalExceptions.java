package com.service.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice //onde tiver classe de excecao tras pra ca e trata.
public class GlobalExceptions {
    @ExceptionHandler(ObjectNotfoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotfoundException ex){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(DataIntegretiViolationExcention.class)
    public ResponseEntity<StandardError> dataIntegretiViolationException(DataIntegretiViolationExcention ex){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        ValidationError errors = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Erro na Validação dos Campos"); // cabeçalho de erro da menssagem.

        for (FieldError erros: ex.getBindingResult().getFieldErrors()){
            errors.addErrors(erros.getField(), erros.getDefaultMessage()); // preenchimento dos erros do cabeçalho
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


}
