package com.jugi.jugi.accmodation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccommodationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("존재하지 않는 호텔 아이디로 조회할 경우, NullPointException이 발생한다.")
    void notExistHotelByIdTest() throws Exception {

        Long accoId = Long.MAX_VALUE;

        // given,when, then
        mockMvc.perform(get("/api/hotel/{id}", accoId))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("존재하지 않는 호텔 아이디입니다."))
                .andDo(print());
    }
}