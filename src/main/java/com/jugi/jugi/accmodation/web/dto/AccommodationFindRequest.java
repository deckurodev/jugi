package com.jugi.jugi.accmodation.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccommodationFindRequest {
    private String name;
    private String address;
    private String streetNameAddress;
}
