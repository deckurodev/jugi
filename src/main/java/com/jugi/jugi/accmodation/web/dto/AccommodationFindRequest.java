package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
public class AccommodationFindRequest {

    @Schema(description = "검색어")
    private String search;

    @Schema(description = "공용 시설")
    private CommonFacility commonFacility;

    @Schema(description = "개인 시설")
    private RoomFacility roomFacility;

    public String getSearch()
    {
        if (search == null)
        {
            return "";
        }

        return search;
    }


    @Schema(description = "공용시설")
    @Getter
    @ToString
    @Setter
    public static class CommonFacility
    {
        @Schema(description = "피트니스", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean fitness;

        @Schema(description = "수영장", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean swimmingPool;

        @Schema(description = "사우나", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean sauna;

        @Schema(description = "골프장", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean golfCourse;

        @Schema(description = "레스토랑", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean restaurant;

        @Schema(description = "엘레베이터", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean elevator;

        @Schema(description = "라운지", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean lounge;

        @Schema(description = "공용PC", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean publicPc;

        @Schema(description = "BBQ", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean bbq;

        @Schema(description = "카페", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean cafe;

        @Schema(description = "공용스파", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean publicSpa;

        @Schema(description = "족구장", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean footballGround;

        @Schema(description = "세미나실", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean meetingRoom;

        @Schema(description = "편의점", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean convenienceStore;

        @Schema(description = "노래방", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean singingRoom;

        @Schema(description = "주방/식당", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean kitchen;

        @Schema(description = "탈수기", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean washingMachine;

        @Schema(description = "건조기", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean dryingMachine;

        @Schema(description = "탈수기", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean spinDryer;

        @Schema(description = "주차장", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean parkingLot;

        @Schema(description = "취사가능여부", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean isMakingFood;

        @Schema(description = "공용샤워실", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean publicShower;

        @Schema(description = "온천", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean hotSpring;

        @Schema(description = "스키장", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean skiResort;
    }

    @Schema(description = "개인 시설")
    @Getter
    @Setter
    public static class RoomFacility
    {
        @Schema(description = "객실스파", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean roomSpa;

        @Schema(description = "미니바", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean minibar;

        @Schema(description = "와이파이", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean wifi;

        @Schema(description = "욕실용품", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean bathSupplies;

        @Schema(description = "TV", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean tv;

        @Schema(description = "에어컨", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean airConditioner;

        @Schema(description = "냉장고", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean refrigerator;

        @Schema(description = "객실샤워실", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean roomShower;

        @Schema(description = "욕조", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean bathTub;

        @Schema(description = "드라이기", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean drier;

        @Schema(description = "다리미", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean iron;

        @Schema(description = "전기밥솥", allowableValues = {"true", "false"}, defaultValue = "false")
        private boolean riceCooker;
    }
}
