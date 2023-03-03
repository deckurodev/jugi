package com.jugi.jugi.accmodation.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomRequest {

    private Long id;

    private Long accommodationId; // 호텔 아이디

    private String name;

    private int roomCount; // 총 객실 수

    private int capacity; // 객실별 최대 숙박 인원

    private int dayPrice; // 1박 기본 요금

}
