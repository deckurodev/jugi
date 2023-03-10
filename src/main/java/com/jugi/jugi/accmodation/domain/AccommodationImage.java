package com.jugi.jugi.accmodation.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "acco_main_image")
@Getter
@Entity
public class AccommodationImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acco_image_id")
    private Long id;

    @Column(name = "main_url")
    private String url;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "acco_id")
//    private Accommodation accommodation;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "acco_detail_image", joinColumns = @JoinColumn(name = "acco_image_id"))
    private Set<AccommodationDetailImage> commonFacilities;
}
