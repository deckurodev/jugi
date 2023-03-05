package com.jugi.jugi.accmodation.domain;

import lombok.Getter;

// 공용시설
@Getter
public enum CommonFacility {

    FITNESS("피트니스"),
    SWIMMING_POLL("수영장"),
    SAUNA("사우나"),
    GOLF_COURSE("골프장"),
    RESTAURANT("레스토랑"),
    ELEVATOR("엘리베이터"),
    LOUNGE("라운지"),
    PUBLIC_PC("공용PC"),
    BBQ("BBQ"),
    CAFE("카페"),
    PUBLIC_SPA("공용스파"),
    FOOTBALL_GROUND("족구장"),
    MEETING_ROOM("세미나실"),
    CONVENIENCE_STORE("편의점"),
    SINGING_ROOM("노래방"),
    KITCHEN("주방/식당"),
    WASHING_MACHINE("세탁기"),
    DRYING_MACHINE("건조기"),
    SPIN_DRYER("탈수기"),
    PARKING_LOT("주차장"),
    MAKING_FOOD("취사가능"),
    PUBLIC_SHOWER("공용샤워실"),
    HOT_SPRING("온천"),
    SKI_RESORT("스키장");

    private final String commonFacilityOptions;

    CommonFacility(String commonFacilityOptions) {
        this.commonFacilityOptions = commonFacilityOptions;
    }
}