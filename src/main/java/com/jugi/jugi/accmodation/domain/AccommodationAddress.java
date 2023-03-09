package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
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
    private String xCode;

    @Column(name = "y_code")
    private String yCode;

    public AccommodationAddress(
            Long locationNumber,
            String address,
            String zipCode,
            String streetAddress,
            String streetZipCode,
            String xCode,
            String yCode)
    {
        this.locationNumber = locationNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.streetZipCode = streetZipCode;
        this.xCode = xCode;
        this.yCode = yCode;
    }
}
