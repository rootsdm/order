package com.service.order.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    // pode usar lombok para criacao de construtores
    public ValidationError(){
        super();
    }

    public ValidationError(LocalDateTime timesTemp, Integer status, String error) {
        super(timesTemp, status, error);
        this.errors = errors;
    }

    public ValidationError(List<FieldMessage> errors) {
        this.errors = errors;
    }


    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldMessage> errors) {
        this.errors = errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName,message));

    }
}
