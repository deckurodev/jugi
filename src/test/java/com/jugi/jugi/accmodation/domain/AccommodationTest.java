package com.jugi.jugi.accmodation.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AccommodationTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void createTest() {
        Accommodation accommodation = new Accommodation();
        accommodation.setName("파크 하얏트 서울");
        accommodation.setDetailStatus(DetailStatus.OPEN);
        accommodation.setBusinessType(BusinessType.HOTEL);
        accommodation.setStar(5);

        AccommodationAddress address = new AccommodationAddress();
        address.setLocationNumber(3620000L);
        address.setAddress("서울");
        address.setZipCode("948-343");
        address.setStreetAddress("서울특별시 강남구");
        address.setStreetZipCode("948343");

        accommodation.setAccommodationAddress(address);

        CommonFacilities commonFacilities = new CommonFacilities();
        List<CommonFacility> commonFacilityList = new ArrayList<>();
        commonFacilityList.add(CommonFacility.CAFE);
        commonFacilityList.add(CommonFacility.SINGING_ROOM);
        commonFacilities.setCommonFacilities(commonFacilityList);
        accommodation.setCommonFacilities(commonFacilities);

        RoomFacilities roomFacilities = new RoomFacilities();
        List<RoomFacility> roomFacilityList = new ArrayList<>();
        roomFacilityList.add(RoomFacility.TV);
        roomFacilityList.add(RoomFacility.AIR_CONDITIONER);
        roomFacilities.setRoomFacilities(roomFacilityList);
        accommodation.setRoomFacilities(roomFacilities);

        Accommodation savedAccommodation = accommodationRepository.save(accommodation);

        assertThat(savedAccommodation.getName()).isEqualTo("파크 하얏트 서울");
        assertThat(savedAccommodation.getCommonFacilities().getCommonFacilities().size()).isEqualTo(2);
        assertThat(savedAccommodation.getRoomFacilities().getRoomFacilities()).contains(RoomFacility.TV, RoomFacility.AIR_CONDITIONER);
    }
}