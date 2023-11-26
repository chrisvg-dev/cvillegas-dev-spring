package com.cvillegas.app.main.exceptions;

import com.cvillegas.app.main.dto.ErrorResponse;
import com.cvillegas.app.main.dto.ExceptionValidatorDto;
import com.cvillegas.app.main.utils.Constants;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionValidatorDto handleInvalidArguments(MethodArgumentNotValidException exception)
    {
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error-> errorMap.put(error.getField(), error.getDefaultMessage()));
        return ExceptionValidatorDto.builder()
                .key(Constants.INVALID_FIELDS)
                .errors(errorMap).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleNotFoundException.class)
    public ExceptionValidatorDto handleInvalidArguments(RoleNotFoundException exception)
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put(Constants.ERROR, exception.getMessage());
        return ExceptionValidatorDto.builder()
                .key(Constants.NOT_FOUND_FIELDS)
                .errors(errorMap).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ExceptionValidatorDto handleDataIntegrity(DataIntegrityViolationException exception)
    {
        Map<String,String> errorMap = new HashMap<>();
        Throwable cause = exception.getRootCause();

        if (cause instanceof PSQLException ex && ((PSQLException) cause).getSQLState().equals(Constants.DUPLICATE_FIELD_CODE)) {
            errorMap.put(Constants.ERROR, ex.getMessage().split("Detail: ")[1]);
        } else {
            errorMap.put(Constants.ERROR, exception.getMessage());
        }

        return ExceptionValidatorDto.builder()
                .key(Constants.DATA_INTEGRITY_VIOLATION)
                .errors(errorMap).build();
    }
}
