package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class AccommodationFindRequest {

    @Schema(description = "검색어")
    private String search;

    @Schema(description = "공용 시설")
    private PublicFacility publicFacility;

    @Schema(description = "개인 시설")
    private PrivateFacility privateFacility;

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
    @Setter
    public static class PublicFacility
    {
        private String fitness;
        private String swimmingPool;
        private String sauna;
        private String golfCourse;
        private String restaurant;
        private String elevator;
        private String lounge;
        private String publicPc;
        private String bbq;
        private String cafe;
        private String publicSpa;
        private String footballGround;
        private String meetingRoom;
        private String convenienceStore;
        private String singingRoom;
        private String kitchen;
        private String washingMachine;
        private String dryingMachine;
        private String spinDryer;
        private String parkingLot;
        private String makingFood;
        private String publicShower;
        private String hotSpring;
        private String skiResort;
    }

    @Schema(description = "개인 시설")
    @Getter
    @Setter
    public static class privateFacility
    {
        private String roomSpa;
        private String minibar;
        private String wifi;
        private String bathSupplies;
        private String tv;
        private String airConditioner;
        private String refrigerator;
        private String roomShower;
        private String bathTub;
        private String drier;
        private String iron;
        private String riceCooker;
    }
}
