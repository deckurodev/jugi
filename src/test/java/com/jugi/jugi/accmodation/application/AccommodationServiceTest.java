package com.jugi.jugi.accmodation.application;

import com.jugi.jugi.accmodation.domain.Accommodation;
import com.jugi.jugi.accmodation.domain.AccommodationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AccommodationServiceTest {
    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void findAllTest() {
        List<Accommodation> all = accommodationRepository.findAll();
        assertThat(all).isNotNull();
    }
}