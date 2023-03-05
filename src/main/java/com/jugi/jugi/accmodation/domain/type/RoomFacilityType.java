package com.jugi.jugi.accmodation.domain.type;

import lombok.Getter;

// 객실시설
@Getter
public enum RoomFacilityType {

    ROOM_SPA("객실스파"),
    MINI_BAR("미니바"),
    WIFI("와이파이"),
    BATH_SUPPLIES("욕실용품"),
    TV("TV"),
    AIR_CONDITIONER("에어컨"),
    REFRIGERATOR("냉장고"),
    ROOM_SHOWER("객실샤워실"),
    BATH_TUB("욕조"),
    DRIER("드라이기"),
    IRON("다리미"),
    RICE_COOKER("전기밥솥");

    private final String roomFacilityOptions;

    RoomFacilityType(String roomFacilityOptions) {
        this.roomFacilityOptions = roomFacilityOptions;
    }
}
