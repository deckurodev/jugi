package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelImage
{
    @Schema(description = "호텔 메인 이미지")
    private String mainUrl;
    @Schema(description = "호텔 상세 이미지")
    private List<String> detailUrl;
}