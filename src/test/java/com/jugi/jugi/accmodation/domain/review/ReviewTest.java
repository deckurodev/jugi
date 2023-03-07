package com.jugi.jugi.accmodation.domain.review;

import com.jugi.jugi.accmodation.domain.*;
import com.jugi.jugi.accmodation.domain.type.BusinessType;
import com.jugi.jugi.accmodation.domain.type.CommonFacilityType;
import com.jugi.jugi.accmodation.domain.type.DetailStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class ReviewTest {

    @Autowired
    AccommodationRepository accommodationRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void saveReviewTest() {

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
        Set<CommonFacility> set = new HashSet<>();

        CommonFacility c1 = new CommonFacility();
        c1.setCommonFacilityType(CommonFacilityType.CAFE);
        CommonFacility c2 = new CommonFacility();
        c2.setCommonFacilityType(CommonFacilityType.SINGING_ROOM);
        set.add(c1);
        set.add(c2);

        commonFacilities.setCommonFacilities(set);
        accommodation.setCommonFacilities(commonFacilities);

        accommodationRepository.save(accommodation);

        Review review = new Review();
        review.setTitle("review title");
        review.setContent("review content");
        review.setRating(4);

        review.setAccommodation(accommodation);

        Review savedReview = reviewRepository.save(review);

        assertThat(savedReview.getAccommodation().getName()).isEqualTo("파크 하얏트 서울");
        assertThat(savedReview.getTitle()).isEqualTo("review title");
    }
}