package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Embeddable
@Getter
@Setter
public class CommonFacilities {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "common_facilities", joinColumns = @JoinColumn(name = "acco_id"))
    private Set<CommonFacility> commonFacilities;

}
