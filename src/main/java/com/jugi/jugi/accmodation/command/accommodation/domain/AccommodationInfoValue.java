package com.jugi.jugi.accmodation.command.accommodation.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"content", "displayOrder"})
public class AccommodationInfoValue {
    private String content;
    private int displayOrder;
    private boolean isBold;
    private String color = "black";

    public AccommodationInfoValue(String content, int displayOrder, boolean isBold, String color) {
        this.content = content;
        this.displayOrder = displayOrder;
        this.isBold = isBold;
        this.color = color;
    }

    public AccommodationInfoValue(String content, int displayOrder) {
        this.content = content;
        this.displayOrder = displayOrder;
    }
}
