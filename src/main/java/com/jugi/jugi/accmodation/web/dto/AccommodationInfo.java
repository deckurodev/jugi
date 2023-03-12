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
public class AccommodationInfo {

    @Schema(description = "상세 정보 속성명")
    private String attribute;

    @Schema(description = "상세 정보 속성 ID")
    private Long accoInfoId;

    @Schema(description = "상세 정보 리스트")
    private List<AccommodationInfoValue> accommodationInfoValueList;

    @Schema(description = "상세 정보 노출 순서")
    private int displayOrder;
}
