package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class AccommodationInfos {

    @Schema(description = "호텔 ID")
    private Long accoId;

    @Schema(description = "상세 정보")
    private List<AccommodationInfo> accommodationInfoList;

    @Schema(description = "기본 정보")
    private MapInfo mapInfo;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class MapInfo
    {
        private String xaddress;
        private String yaddress;
    }
}
