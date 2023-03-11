package com.jugi.jugi.accmodation.global.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handlerException(CustomException e) {
        log.error("errorCode: {}, message: {}", e.getStatus(), e.getErrorMessage());
        return new ResponseEntity(e.getErrorMessage(), e.getStatus());
    }
}
