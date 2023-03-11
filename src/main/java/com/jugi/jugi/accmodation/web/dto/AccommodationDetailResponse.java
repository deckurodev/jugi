package com.jugi.jugi.accmodation.web.dto;

import com.jugi.jugi.accmodation.command.accommodation.domain.Accommodation;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationAddress;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AccommodationDetailResponse {

    private String name;
    private Integer star;
    private AccommodationAddress accommodationAddress;

    @Builder
    public AccommodationDetailResponse(String name, Integer star, AccommodationAddress address) {
        this.name = name;
        this.star = star;
        this.accommodationAddress = address;
    }

    public static AccommodationDetailResponse toResponse(Accommodation accommodation) {
        return AccommodationDetailResponse.builder()
                .name(accommodation.getName())
                .star(accommodation.getStar())
                .address(accommodation.getAccommodationAddress())
                .build();
    }

}
