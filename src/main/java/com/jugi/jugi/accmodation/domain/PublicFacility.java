package com.jugi.jugi.accmodation.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PublicFacility {

    @Column(name = "fitness")
    private String fitness;

    @Column(name = "swimming_pool")
    private String swimmingPool;

    @Column(name = "sauna")
    private String sauna;

    @Column(name = "golf_course")
    private String golfCourse;

    @Column(name = "restaurant")
    private String restaurant;

    @Column(name = "elevator")
    private String elevator;

    @Column(name = "lounge")
    private String lounge;

    @Column(name = "public_pc")
    private String publicPc;

    @Column(name = "bbq")
    private String bbq;

    @Column(name = "cafe")
    private String cafe;

    @Column(name = "public_spa")
    private String publicSpa;

    @Column(name = "football_groud")
    private String footballGround;

    @Column(name = "meeting_rom")
    private String meetingRoom;

    @Column(name = "convenience_store")
    private String convenienceStore;

    @Column(name = "singing_room")
    private String singingRoom;

    @Column(name = "kitchen")
    private String kitchen;

    @Column(name = "washing_machine")
    private String washingMachine;

    @Column(name = "drying_machine")
    private String dryingMachine;

    @Column(name = "spin_dryer")
    private String spinDryer;

    @Column(name = "parking_lot")
    private String parkingLot;

    @Column(name = "making_food")
    private String makingFood;

    @Column(name = "public_shower")
    private String publicShower;

    @Column(name = "hot_spring")
    private String hotSpring;

    @Column(name = "ski_resort")
    private String skiResort;
}
