package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Getter
@Setter
public class CommonFacilities {

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "common_facility", joinColumns = @JoinColumn(name = "accm_id"))
    private List<CommonFacility> commonFacilities;

}
