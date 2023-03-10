package com.jugi.jugi.accmodation.domain.review;

import com.jugi.jugi.accmodation.domain.Accommodation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "review")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "rating")
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acco_id")
    private Accommodation accommodation;

    @Column(name = "reg_dt", updatable = false)
    private LocalDateTime registerDate;

    @Column(name = "mod_dt", updatable = false)
    private LocalDateTime modifyDate;
}
