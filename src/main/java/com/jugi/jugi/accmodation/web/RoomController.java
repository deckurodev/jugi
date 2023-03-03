package com.jugi.jugi.accmodation.web;

import com.jugi.jugi.accmodation.application.RoomService;
import com.jugi.jugi.accmodation.domain.RoomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "객실 정보", description = "객실 정보 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    @Operation(summary = "객실 상세 정보", description = "호텔 아이디로 객실 상세 정보 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = RoomResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters(
            @Parameter(name = "accommodationId", description = "호텔 아이디", example = "1")
    )
    // 객실 상세 조회
    @GetMapping("/{accommodationId}")
    public List<RoomResponse> getRoomDetail(@PathVariable Long accommodationId) {
        return roomService.getRoomDetail(accommodationId);
    }

    @Operation(summary = "객실 리스트 조회", description = "객실 리스트 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = RoomResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    // 객실 리스트
    @GetMapping
    public List<RoomResponse> getRoomList() {
        return roomService.getRoomList();
    }

    // 객실 정보 수정

    // 객실 삭제
}
