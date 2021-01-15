package com.example.demo.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class Validator {

    public static String validateField(BindingResult result) {
        StringBuilder sb = new StringBuilder();
        if (result.getErrorCount() > 0) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError: fieldErrors) {
                sb.append("[").append(fieldError).append("]");
            }
        }
        return sb.toString();
    }
}
