package com.jugi.jugi.accmodation.application;

import com.jugi.jugi.accmodation.domain.RoomResponse;
import com.jugi.jugi.accmodation.domain.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    // 객실 상세 조회
    public List<RoomResponse> getRoomDetail(Long accommodationId) {
        return roomRepository.findByAccommodationId(accommodationId);
    }

    // 객실 리스트 조회
    public List<RoomResponse> getRoomList() {
        return roomRepository.findAll();
    }

    // 객실 수정

    // 객실 삭제
}
