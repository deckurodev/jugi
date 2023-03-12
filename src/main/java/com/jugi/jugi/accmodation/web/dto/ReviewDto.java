package com.jugi.jugi.accmodation.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReviewDto {

    @Schema(description = "리뷰 ID")
    private Long reviewId;
    @Schema(description = "리뷰 내용")
    private String content;
    @Schema(description = "평점")
    private String rating;
    @Schema(description = "리뷰 제목")
    private String title;
    @Schema(description = "리뷰 등록일")
    private String regDt;
    @Schema(description = "호텔 ID")
    private Long accoId;
    @Schema(description = "이미지 첨부")
    private List<String> imgUrl;
}
