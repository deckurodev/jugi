package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@Setter
@NoArgsConstructor
public class AccommodationDetailImage {

    @Column(name = "accm_detail_image_id")
    private Long id;

    @Column(name = "detail_url")
    private String url;

    @Column(name = "display_order")
    private String displayOrder;
}
