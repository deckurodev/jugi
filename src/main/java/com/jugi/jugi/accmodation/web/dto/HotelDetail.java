package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class HotelDetail {

    @Schema(description = "호텔 명")
    private String accommodationName;

    @Schema(description = "호텔 ID")
    private Long accoId;

    @Schema(description = "호텔 주소")
    private String address;

    @Schema(description = "사장님 한마디")
    private String partnerTalk;

    @Schema(description = "호텔 메인 이미지")
    private String mainImageUrl;

    @Schema(description = "호텔 상세 이미지")
    private List<String> detailImageUrl;

    @Schema(description = "기본 정보")
    private AccommodationInfos accommodationInfos;

    @Schema(description = "편의 시설 및 서비스")
    private List<String> facilities;

    @Schema(description = "판매자 정보")
    private SellerInfo sellerInfo;

    @Data
    @NoArgsConstructor
    public static class SellerInfo
    {
        private String phoneNumber;
        private String address;
        private String name;
        private String manageNumber;
    }

    @Data
    @NoArgsConstructor
    public static class Reviews{
        private List<Review> reviews;
    }

    @Data
    @NoArgsConstructor
    public static class Review
    {
        private Long id;
        private String title;
        private String content;
        private Integer rating;
        private LocalDateTime registerDate;
    }


    @Data
    @NoArgsConstructor
    public static class AccommodationInfoValue
    {
        private String content;
        private int displayOrder;
        private boolean isBold;
        private String color = "black";
    }
}
