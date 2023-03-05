package com.jugi.jugi.accmodation.domain.type;

import lombok.Getter;

@Getter
public enum BusinessType {
    HOTEL("일반호텔/숙박업기타"),
    INN("여관/여인숙"),
    LIVING("생활숙박"),
    ;
    private final String detailType;

    BusinessType(String detailType) {
        this.detailType = detailType;
    }
}
