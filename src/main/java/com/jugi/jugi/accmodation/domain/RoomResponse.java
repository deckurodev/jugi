package com.jugi.jugi.accmodation.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "accommodation_room")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "accommodation_id") // 호텔 아이디
//    private Accommodation accommodation;

    @Column(name = "name")
    private String name;

    @Column(name = "room_count")
    private int roomCount; // 총 객실 수

    @Column(name = "capacity")
    private int capacity; // 객실별 최대 숙박 인원

    @Column(name = "day_price")
    private int dayPrice; // 1박 기본 요금

    @Column(name = "description")
    private String description; // 객실 이용안내

}
