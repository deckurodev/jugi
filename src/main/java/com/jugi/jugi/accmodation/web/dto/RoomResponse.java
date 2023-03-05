package com.jugi.jugi.accmodation.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {

    private Long id;

    private Long accommodationId; // 호텔 아이디

    private String name;

    private int roomCount; // 총 객실 수

    private int capacity; // 객실별 최대 숙박 인원

    private int dayPrice; // 1박 기본 요금

    private String description; // 객실 이용안내

    private List<AccommodationFindResult> accommodationFindResultList;
}
