package com.jugi.jugi.accmodation.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "accommodation")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "detail_status")
    @Enumerated(EnumType.STRING)
    private DetailStatus detailStatus;

    @Column(name = "business_type")
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private Integer star;

    @Embedded
    private AccommodationAddress accommodationAddress;

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "common_facility")
    @Enumerated(EnumType.STRING)
    private CommonFacility commonFacility;

    @Column(name = "room_facility")
    @Enumerated(EnumType.STRING)
    private RoomFacility roomFacility;
}
