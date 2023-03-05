package com.jugi.jugi.accmodation.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.jugi.jugi.accmodation.domain.CommonFacility.ELEVATOR;

@Transactional
@SpringBootTest
class AccommodationTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void createTest()
    {
  
    }

}