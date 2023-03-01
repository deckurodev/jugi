package com.jugi.jugi.accmodation.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrivateFacility {
    @Column(name = "room_spa")
    private String roomSpa;

    @Column(name = "mini_bar")
    private String minibar;

    @Column(name = "wifi")
    private String wifi;

    @Column(name = "bath_supplies")
    private String bathSupplies;

    @Column(name = "tv")
    private String tv;

    @Column(name = "air_conditioner")
    private String airConditioner;

    @Column(name = "refrigerator")
    private String refrigerator;

    @Column(name = "room_shower")
    private String roomShower;

    @Column(name = "bath_tub")
    private String bathTub;

    @Column(name = "drier")
    private String drier;

    @Column(name = "iron")
    private String iron;

    @Column(name = "rice_cooker")
    private String riceCooker;
}
