package com.jugi.jugi.accmodation.domain;

import com.jugi.jugi.accmodation.domain.type.CommonFacilityType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor
public class CommonFacility {

    @Column(name = "common_type")
    @Enumerated(EnumType.STRING)
    private CommonFacilityType commonFacilityType;

    @Column(name = "reg_dt", updatable = false)
    private LocalDateTime registerDate;

    public CommonFacility(CommonFacilityType commonFacilityType, LocalDateTime registerDate)
    {
        this.commonFacilityType = commonFacilityType;
        this.registerDate = registerDate;
    }
}
