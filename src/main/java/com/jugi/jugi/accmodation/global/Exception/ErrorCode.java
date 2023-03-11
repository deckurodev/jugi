package com.jugi.jugi.accmodation.global.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 존재하지 않는 호텔 아이디
    NOT_FOUND_HOTEL_ID(HttpStatus.BAD_REQUEST, "존재하지 않는 호텔 아이디입니다.");

    private final HttpStatus status;
    private final String message;
}
