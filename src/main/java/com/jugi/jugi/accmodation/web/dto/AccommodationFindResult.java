package com.jugi.jugi.accmodation.web.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationFindResult {
    private Long id;
    private String autonomousZoneNumber;
    private String manageNumber;
    private String approvalDate;
    private String hotelDetailStatus;
    private String phoneNumber;
    private String locationArea;
    private String zipCode;
    private String address;
    private String streetNameAddress;
    private String streetZipCode;
    private String name;
    private String businessType;
    private String xaddress;
    private String yaddress;
    private int groundFloor;
    private int bottomFloor;
    private HotelImage hotelImage;
    private RoomFacility roomFacility;
    private CommonFacility commonFacility;

}
