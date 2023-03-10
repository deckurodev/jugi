package com.jugi.jugi.accmodation.command.accommodation.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"content", "displayOrder"})
public class AccommodationInfoValue {
    private String content;
    private int displayOrder;


    public AccommodationInfoValue(String content, int displayOrder) {
        this.content = content;
        this.displayOrder = displayOrder;
    }
}
