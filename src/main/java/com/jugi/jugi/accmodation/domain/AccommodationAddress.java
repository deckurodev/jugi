package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
public class AccommodationAddress {
    @Column(name = "location_number")
    private Long locationNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "street_zip_code")
    private String streetZipCode;

    @Column(name = "x_code")
    private double xCode;

    @Column(name = "y_code")
    private double yCode;
}
