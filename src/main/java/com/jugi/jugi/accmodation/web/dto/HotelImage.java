package com.jugi.jugi.accmodation.web.dto;

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
    private String mainUrl;
    private List<String> detailUrl;
}