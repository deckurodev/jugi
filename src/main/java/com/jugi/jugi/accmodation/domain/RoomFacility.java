package com.jugi.jugi.accmodation.domain;

import com.jugi.jugi.accmodation.domain.type.RoomFacilityType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor
public class RoomFacility {

    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomFacilityType roomFacilityType;

    @Column(name = "reg_dt", updatable = false)
    private LocalDateTime registerDate;
}
