package com.jugi.jugi.accmodation.command.accommodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Embeddable
@Getter
@NoArgsConstructor
public class CommonFacilities {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "common_facilities", joinColumns = @JoinColumn(name = "acco_id"))
    private Set<CommonFacility> commonFacilities;

    public CommonFacilities(Set<CommonFacility> commonFacilities)
    {
        this.commonFacilities = commonFacilities;
    }
}
