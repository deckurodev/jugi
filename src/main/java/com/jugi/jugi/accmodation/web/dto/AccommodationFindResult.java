package com.jugi.jugi.accmodation.web.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class AccommodationFindResult {
    private Long id;
    private String autonomousZoneNumber; // 개방 자치 단체 코드
    private String manageNumber; // 관리 번호
    private String approvalDate; // 인허가 일자
    private String hotelDetailStatus; // 상세 영업 상태명
    private String phoneNumber; // 소재지 전화
    private String locationArea; // 소재지 면적
    private String zipCode; // 소재지 우편번호
    private String address; // 전체 주소
    private String streetNameAddress; // 도로명 주소
    private String streetZipCode; // 도로명 우편번호
    private String name; // 사업자 명
    private String businessType; // 업태구분명
    private String xAddress;
    private String yAddress;
    private int groundFloor;
    private int bottomFloor;
    private HotelImage hotelImage;

    @Getter
    @Setter
    public static class HotelImage
    {
        private String mainUrl;
        private List<String> detailUrl;
    }
}
