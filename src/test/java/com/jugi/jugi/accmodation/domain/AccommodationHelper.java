package com.jugi.jugi.accmodation.domain;

import com.google.common.collect.Sets;
import com.jugi.jugi.accmodation.command.accommodation.domain.*;
import com.jugi.jugi.accmodation.command.accommodation.domain.type.BusinessType;
import com.jugi.jugi.accmodation.command.accommodation.domain.type.CommonFacilityType;
import com.jugi.jugi.accmodation.command.accommodation.domain.type.DetailStatus;

import java.time.LocalDateTime;

public class AccommodationHelper {

    public static Accommodation accommodation = new Accommodation(
            "저기어때",
            DetailStatus.OPEN,
            BusinessType.HOTEL,
            "001",
            4,
            new AccommodationAddress(
                    1L,
                    "서울시 강남구",
                    "123",
                    "영동대로",
                    "1230",
                    "3.123123",
                    "4.1231231"
            ),
            LocalDateTime.now(),
            "123-123-123",
            new CommonFacilities(
                    Sets.newHashSet(
                            new CommonFacility(CommonFacilityType.BBQ, LocalDateTime.now())
                    )
            ),
            new RoomFacilities(),
            null
    );

    public static AccommodationAddress accommodationAddress = new AccommodationAddress(
        1L,
            "서울시 강남구",
            "123",
            "영동대로",
            "1230",
            "3.123123",
            "4.1231231"
    );

    public static CommonFacilities commonFacilities = new CommonFacilities(
            Sets.newHashSet(
                    new CommonFacility(CommonFacilityType.BBQ, LocalDateTime.now())
            )
    );

}
