package com.jugi.jugi.accmodation.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "accommodation")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
}
