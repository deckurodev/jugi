package com.jugi.jugi.accmodation.application;

import com.jugi.jugi.accmodation.domain.*;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class AccommodationServiceTest {
    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void findAllTest()
    {
        List<Accommodation> all = accommodationRepository.findAll();
        Assertions.assertThat(all).isNotNull();
    }

    @Test
    void createTest()
    {
        Accommodation accommodation = new Accommodation();
        accommodation.setName("name");
        AccommodationAddress accommodationAddress = new AccommodationAddress();
        accommodationAddress.setAddress("address");
        accommodationAddress.setStreetAddress("street address");
        accommodationAddress.setYCode(1);
        accommodationAddress.setXCode(1);
        accommodationAddress.setZipCode("zip");
        accommodationAddress.setLocationNumber(1L);
        accommodation.setAccommodationAddress(accommodationAddress);

        accommodation.setStar(1);
        accommodation.setBusinessType(BusinessType.HOTEL);
        accommodation.setApprovalDate(LocalDateTime.now());
        accommodation.setApprovalDate(LocalDateTime.now());
        PublicFacility publicFacility = PublicFacility.builder().build();;
        accommodation.setPublicFacilities(Lists.newArrayList(publicFacility));
        accommodationRepository.save(accommodation);
    }
}