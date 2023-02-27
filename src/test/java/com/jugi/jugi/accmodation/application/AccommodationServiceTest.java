package com.jugi.jugi.accmodation.application;

import com.jugi.jugi.accmodation.domain.Accommodation;
import com.jugi.jugi.accmodation.domain.AccommodationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}