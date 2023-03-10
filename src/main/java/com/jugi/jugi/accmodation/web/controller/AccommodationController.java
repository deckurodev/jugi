package com.jugi.jugi.accmodation.web.controller;

import com.jugi.jugi.accmodation.application.AccommodationFindService;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindRequest;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindResult;
import com.jugi.jugi.accmodation.web.dto.HotelDetail;
import com.jugi.jugi.accmodation.web.dto.ReviewDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

@Tag(name = "숙박 검색", description = "숙박 검색 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AccommodationController {

    private final AccommodationFindService accommodationFindService;

    @Operation(summary = "호텔 검색", description = "호텔 타입만 검색합니다.")
    @Parameters({
            @Parameter(name = "request", description = "검색어 파라미터", example = "경기도"),
            @Parameter(name = "skip", description = "오프셋(디폴트 0)", example = "10"),
            @Parameter(name = "take", description = "검색 사이즈(디폴트 100)", example = "10")
    })
    @PostMapping("/hotel")
    public List<AccommodationFindResult> findAccommodation(
            @RequestBody AccommodationFindRequest request,
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @RequestParam(value = "take", defaultValue = "30") int take

    ) throws IOException, IllegalAccessException {
        if (take > 30)
        {
            throw new RemoteException("최대 take 30 초과");
        }

        return accommodationFindService.findResult(request, skip, take);
    }

    @Operation(summary = "호텔 상세 검색", description = "호텔 ID 상세 조회합니다.")
    @Parameters({
            @Parameter(name = "accoId", description = "호텔 ID", example = "7")
    })
    @GetMapping("/hotel/{accoId}")
    public HotelDetail findHotelById(@PathVariable("accoId") Long accoId) throws IOException
    {
        return accommodationFindService.findHotelById(accoId);
    }

    @Operation(summary = "호텔 리뷰 검색", description = "호텔 리뷰를 조회합니다.")
    @Parameters({
            @Parameter(name = "accoId", description = "호텔 ID", example = "7")
    })
    @GetMapping("/review/{accoId}")
    public ReviewDto findReviewById(@PathVariable("accoId") Long accoId) throws Exception
    {
        return accommodationFindService.findReviewById(accoId);
    }
}
