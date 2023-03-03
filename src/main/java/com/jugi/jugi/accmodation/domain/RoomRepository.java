package com.jugi.jugi.accmodation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomResponse, Long> {

    // 호텔 아이디로 객실정보 조회
    List<RoomResponse> findByAccommodationId(Long accommodationId);
}

