package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccommodationInfoValue {

    @Schema(description = "상세 속성 내용")
    private String content;

    @Schema(description = "상세 속성 노출 순서")
    private int displayOrder;

    @Schema(description = "굵은체 여부")
    private boolean bold;

    @Schema(description = "컬러")
    private String color = "black";

    public AccommodationInfoValue(String content, int displayOrder, boolean isBold, String color) {
        this.content = content;
        this.displayOrder = displayOrder;
        this.bold = bold;
        this.color = color;
    }

    public AccommodationInfoValue(String content, int displayOrder) {
        this.content = content;
        this.displayOrder = displayOrder;
    }
}
