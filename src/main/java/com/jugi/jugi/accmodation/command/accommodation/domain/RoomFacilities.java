package com.jugi.jugi.accmodation.command.accommodation.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Getter
public class RoomFacilities {

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "room_facilities", joinColumns = @JoinColumn(name = "acco_id"))
    private List<RoomFacility> roomFacilities;
}
