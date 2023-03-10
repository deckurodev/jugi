package com.jugi.jugi.accmodation.command.review.domain;

import com.jugi.jugi.accmodation.command.accommodation.domain.Accommodation;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationRepository;
import com.jugi.jugi.accmodation.domain.AccommodationHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class ReviewTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void saveReviewTest()
    {
        Accommodation accommodation = AccommodationHelper.accommodation;

        Review review = new Review(
                "review title",
                "review content",
                4,
                accommodation,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        Review savedReview = reviewRepository.save(review);
        assertThat(savedReview.getTitle()).isEqualTo("review title");
        assertThat(savedReview.getContent()).isEqualTo("review content");

        Assertions.assertThat(savedReview.getAccommodation()).isNotNull();
        Assertions.assertThat(savedReview.getId()).isNotNull();
    }
}