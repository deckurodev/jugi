package com.jugi.jugi.accmodation.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class HotelDetailResponse {
    private String accommodationName;

    private String address;
    private String partnerTalk;

    private String mainImageUrl;
    private List<String> detailImageUrl;

    private Reviews reviews;

    private AccommodationInfos accommodationInfos;

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
    public static class AccommodationInfos
    {
        private List<AccommodationInfo> accommodationInfoList;
    }

    @Data
    @NoArgsConstructor
    public static class AccommodationInfo
    {
        private Long id;
        private String attribute;
        private List<AccommodationInfoValue> valueList;
        private int displayOrder;

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
