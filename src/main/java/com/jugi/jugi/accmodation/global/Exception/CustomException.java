package com.jugi.jugi.accmodation.global.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private HttpStatus status;
    private String errorMessage;

    public CustomException(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.errorMessage = errorCode.getMessage();
    }
}
