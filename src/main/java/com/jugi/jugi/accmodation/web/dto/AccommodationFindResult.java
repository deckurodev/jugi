package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationFindResult {

    @Schema(description = "호텔 ID")
    private Long id;

    @Schema(description = "개방 자치 단체 번호")
    private String autonomousZoneNumber;

    @Schema(description = "관리 번호")
    private String manageNumber;

    @Schema(description = "영업 허가 날짜")
    private String approvalDate;

    @Schema(description = "호텔 상태")
    private String hotelDetailStatus;

    @Schema(description = "전화번호")
    private String phoneNumber;

    @Schema(description = "소재지면적")
    private String locationArea;

    @Schema(description = "소재지 우편번호")
    private String zipCode;

    @Schema(description = "주소")
    private String address;

    @Schema(description = "도로명 전체 주소")
    private String streetNameAddress;

    @Schema(description = "도로명 우편번호")
    private String streetZipCode;

    @Schema(description = "호텔 이름")
    private String name;

    @Schema(description = "업태명 구분")
    private String businessType;

    @Schema(description = "좌표정보(x)")
    private String xAddress;

    @Schema(description = "좌표정보(y)")
    private String yAddress;

    @Schema(description = "호텔 이미지")
    private HotelImage hotelImage;

    @Schema(description = "공용 시설")
    private List<String> common;

    @Schema(description = "객실 시설")
    private List<String> room;
}
