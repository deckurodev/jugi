package com.jugi.jugi.accmodation.command.accommodation.domain;

import com.jugi.jugi.accmodation.command.accommodation.domain.type.DetailStatus;
import com.jugi.jugi.accmodation.command.accommodation.domain.type.BusinessType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "accommodation")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Accommodation {
    @Id
    @Column(name = "acco_id")
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

    @Column(name = "manage_number")
    private String manageNumber;

    private Integer star;

    @Embedded
    private AccommodationAddress accommodationAddress;

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private CommonFacilities commonFacilities;

    @Embedded
    private RoomFacilities roomFacilities;

    @OneToMany(
            fetch = FetchType.LAZY
            , cascade = CascadeType.ALL
            , mappedBy = "accommodation"
    )
    private List<AccommodationInfo> accommodationInfoList;

    public Accommodation(
            String name,
            DetailStatus detailStatus,
            BusinessType businessType,
            String manageNumber,
            Integer star,
            AccommodationAddress accommodationAddress,
            LocalDateTime approvalDate,
            String phoneNumber,
            CommonFacilities commonFacilities,
            RoomFacilities roomFacilities,
            List<AccommodationInfo> accommodationInfoList)
    {
        this.name = name;
        this.detailStatus = detailStatus;
        this.businessType = businessType;
        this.manageNumber = manageNumber;
        this.star = star;
        this.accommodationAddress = accommodationAddress;
        this.approvalDate = approvalDate;
        this.phoneNumber = phoneNumber;
        this.commonFacilities = commonFacilities;
        this.roomFacilities = roomFacilities;
        this.accommodationInfoList = accommodationInfoList;
    }

    public void setAccommodationInfoList(List<AccommodationInfo> accommodationInfos)
    {
        this.accommodationInfoList = accommodationInfos;
    }
}
