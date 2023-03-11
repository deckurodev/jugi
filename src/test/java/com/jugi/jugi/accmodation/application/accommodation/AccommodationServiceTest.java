package com.jugi.jugi.accmodation.application.accommodation;

import com.jugi.jugi.accmodation.command.accommodation.domain.Accommodation;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationRepository;
import com.jugi.jugi.accmodation.domain.AccommodationHelper;
import com.jugi.jugi.accmodation.web.dto.AccommodationDetailResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AccommodationServiceTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    AccommodationService accommodationService;

    @Test
    @DisplayName("호텔 아이디로 상세 조회를 하면 AccommodationDetailResponse를 반환한다.")
    void searchById() {
        // given
        Accommodation accommodation = AccommodationHelper.accommodation;
        Accommodation savedAccommodation = accommodationRepository.save(accommodation);

        // when
        AccommodationDetailResponse searchDetail = accommodationService.searchById(savedAccommodation.getId());

        // then
        assertThat(savedAccommodation.getName()).isEqualTo(searchDetail.getName());
        assertThat(savedAccommodation.getStar()).isEqualTo(searchDetail.getStar());
        assertThat(savedAccommodation.getAccommodationAddress().getAddress()).isEqualTo(searchDetail.getAccommodationAddress().getAddress());
        assertThat(searchDetail).isInstanceOf(AccommodationDetailResponse.class);
    }
}