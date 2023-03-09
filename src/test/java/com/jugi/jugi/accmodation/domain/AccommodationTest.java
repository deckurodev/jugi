package com.jugi.jugi.accmodation.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccommodationTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void createTest() {
        Accommodation accommodation = AccommodationHelper.accommodation;
        Accommodation saved = accommodationRepository.save(accommodation);
        assertThat(saved.getName()).isEqualTo("저기어때");
    }
}