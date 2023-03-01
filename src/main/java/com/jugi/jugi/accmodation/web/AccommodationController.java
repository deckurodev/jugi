package com.jugi.jugi.accmodation.web;

import com.jugi.jugi.accmodation.application.AccommodationFindService;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "숙박 검색", description = "숙박 검색 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AccommodationController {

    private final AccommodationFindService accommodationFindService;

    @Operation(summary = "숙박 검색", description = "지역에 대한 posts들 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = AccommodationFindResult.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "search", description = "검색어", example = "경기도"),
            @Parameter(name = "skip", description = "오프셋(디폴트 0)", example = "10"),
            @Parameter(name = "take", description = "검색 사이즈(디폴트 100)", example = "10")
    })
    @GetMapping
    public List<AccommodationFindResult> findAccommodation(
            @RequestParam("search") String search,
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @RequestParam(value = "take", defaultValue = "100") int take

    ) throws IOException {
        return accommodationFindService.findResult(search, skip, take);
    }
}
