package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Getter
@Setter
public class RoomFacilities {

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "room_facilities", joinColumns = @JoinColumn(name = "acco_id"))
    private List<RoomFacility> roomFacilities;
}
