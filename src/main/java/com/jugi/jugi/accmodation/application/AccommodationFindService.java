package com.jugi.jugi.accmodation.application;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.google.common.collect.Lists;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindRequest;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindResult;
import com.jugi.jugi.accmodation.web.dto.HotelDetail;
import com.jugi.jugi.accmodation.web.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Log4j2
@RequiredArgsConstructor
@Service
public class AccommodationFindService {

    private final ElasticsearchClient client;

    public List<AccommodationFindResult> findResult(AccommodationFindRequest request, int skip, int size) throws IOException, IllegalAccessException {

        Query byName = MatchQuery.of(m -> m
                .field("name")
                .query(request.getSearch())
        )._toQuery();

        Query businessType = TermQuery.of(m ->
                m
                        .field("businessType.keyword")
                        .value("HOTEL")
        )._toQuery();

        Query byAddress = MatchQuery.of(m -> m
                .field("address")
                .query(request.getSearch())
        )._toQuery();

        Query byStreetAddress = MatchQuery.of(m -> m
                .field("streetNameAddress")
                .query(request.getSearch())
        )._toQuery();

        AccommodationFindRequest.CommonFacility commonFacility = request.getCommonFacility();
        AccommodationFindRequest.RoomFacility roomFacility = request.getRoomFacility();

        // 공용 시설 쿼리
        List<Query> commonQuery = getCommonFacilityQuery(commonFacility);

        // 사설 시설 쿼리
        List<Query> roomQuery = getRoomFacilityQuery(roomFacility);

        SearchResponse<AccommodationFindResult> response = client.search(s -> s
                        .index("accommodation")
                        .query(q -> q
                                .bool(b -> b
                                        .should(byName)
                                        .should(byAddress)
                                        .should(byStreetAddress)
                                        .must(businessType)
                                        .must(commonQuery)
                                        .must(roomQuery)
                                )
                        )
                        .from(skip)
                        .size(size)
                ,
                AccommodationFindResult.class
        );

        List<Hit<AccommodationFindResult>> hits = response.hits().hits();
        List<AccommodationFindResult> results = new ArrayList<>();

        for (Hit<AccommodationFindResult> hit : hits) {
            AccommodationFindResult accommodationFindResult = hit.source();
            results.add(accommodationFindResult);
        }

        return results;
    }

    private List<Query> getRoomFacilityQuery(AccommodationFindRequest.RoomFacility roomFacility)
    {
        if (roomFacility == null)
        {
            return new ArrayList<>();
        }

        Query roomSpa = roomFacility.isRoomSpa() ? TermQuery.of(m -> m.field("room.keyword").value("ROOM_SPA"))._toQuery() : null;
        Query miniBar = roomFacility.isMinibar() ? TermQuery.of(m -> m.field("room.keyword").value("MINI_BAR"))._toQuery() : null;
        Query wifi = roomFacility.isWifi() ? TermQuery.of(m -> m.field("room.keyword").value("WIFI"))._toQuery() : null;
        Query bathSupplies = roomFacility.isBathSupplies() ? TermQuery.of(m -> m.field("room.keyword").value("BATH_SUPPLIES"))._toQuery() : null;
        Query tv = roomFacility.isTv() ? TermQuery.of(m -> m.field("room.keyword").value("TV"))._toQuery() : null;
        Query airConditioner = roomFacility.isAirConditioner() ? TermQuery.of(m -> m.field("room.keyword").value("AIR_CONDITIONER"))._toQuery() : null;
        Query refrigerator = roomFacility.isRefrigerator() ? TermQuery.of(m -> m.field("room.keyword").value("REFRIGERATOR"))._toQuery() : null;
        Query roomShower = roomFacility.isRoomShower() ? TermQuery.of(m -> m.field("room.keyword").value("ROOM_SHOWER"))._toQuery() : null;
        Query bathTub = roomFacility.isBathTub() ? TermQuery.of(m -> m.field("room.keyword").value("BATH_TUB"))._toQuery() : null;
        Query drier = roomFacility.isDrier() ? TermQuery.of(m -> m.field("room.keyword").value("DRIER"))._toQuery() : null;
        Query iron = roomFacility.isIron() ? TermQuery.of(m -> m.field("room.keyword").value("IRON"))._toQuery() : null;
        Query riceCooker = roomFacility.isRiceCooker() ? TermQuery.of(m -> m.field("room.keyword").value("RICE_COOKER"))._toQuery() : null;

        return Lists.newArrayList(
                roomSpa,
                miniBar,
                wifi,
                bathSupplies,
                tv,
                airConditioner,
                refrigerator,
                roomShower,
                bathTub,
                drier,
                iron,
                riceCooker
        )
                .stream()
                .filter(Objects::nonNull).collect(Collectors.toList());
    }

    private static List<Query> getCommonFacilityQuery(AccommodationFindRequest.CommonFacility commonFacility) {

        if (commonFacility == null)
        {
            return Lists.newArrayList();
        }

        Query fitness = commonFacility.isFitness() ? TermQuery.of(m -> m.field("common.keyword").value("FITNESS"))._toQuery() : null;
        Query swimmingPool = commonFacility.isSwimmingPool() ? TermQuery.of(m -> m.field("common.keyword").value("SWIMMING_POLL"))._toQuery() : null;
        Query sauna = commonFacility.isSauna() ? TermQuery.of(m -> m.field("common.keyword").value("SAUNA"))._toQuery() : null;
        Query golfCourse = commonFacility.isGolfCourse() ? TermQuery.of(m -> m.field("common.keyword").value("GOLF_COURSE"))._toQuery() : null;
        Query restaurant = commonFacility.isRestaurant() ? TermQuery.of(m -> m.field("common.keyword").value("RESTAURANT"))._toQuery() : null;
        Query elevator = commonFacility.isElevator() ? TermQuery.of(m -> m.field("common.keyword").value("ELEVATOR"))._toQuery() : null;
        Query lounge = commonFacility.isLounge() ? TermQuery.of(m -> m.field("common.keyword").value("LOUNGE"))._toQuery() : null;
        Query publicPc = commonFacility.isPublicPc() ? TermQuery.of(m -> m.field("common.keyword").value("PUBLIC_PC"))._toQuery() : null;
        Query bbq = commonFacility.isBbq() ? TermQuery.of(m -> m.field("common.keyword").value("BBQ"))._toQuery() : null;
        Query cafe = commonFacility.isCafe() ? TermQuery.of(m -> m.field("common.keyword").value("CAFE"))._toQuery() : null;
        Query publicSpa = commonFacility.isPublicSpa() ? TermQuery.of(m -> m.field("common.keyword").value("PUBLIC_SPA"))._toQuery() : null;
        Query footballGround = commonFacility.isFootballGround() ? TermQuery.of(m -> m.field("common.keyword").value("FOOTBALL_GROUND"))._toQuery() : null;
        Query meetingRoom = commonFacility.isMeetingRoom() ? TermQuery.of(m -> m.field("common.keyword").value("MEETING_ROOM"))._toQuery() : null;
        Query convenienceStore = commonFacility.isConvenienceStore() ? TermQuery.of(m -> m.field("common.keyword").value("CONVENIENCE_STORE"))._toQuery() : null;
        Query singingRoom = commonFacility.isSingingRoom() ? TermQuery.of(m -> m.field("common.keyword").value("SINGING_ROOM"))._toQuery() : null;
        Query kitchen = commonFacility.isKitchen() ? TermQuery.of(m -> m.field("common.keyword").value("KITCHEN"))._toQuery() : null;
        Query washingMachine = commonFacility.isWashingMachine() ? TermQuery.of(m -> m.field("common.keyword").value("WASHING_MACHINE"))._toQuery() : null;
        Query dryingMachine = commonFacility.isDryingMachine() ? TermQuery.of(m -> m.field("common.keyword").value("DRYING_MACHINE"))._toQuery() : null;
        Query spinDryer = commonFacility.isSpinDryer() ? TermQuery.of(m -> m.field("common.keyword").value("SPIN_DRYER"))._toQuery() : null;
        Query parkingLot = commonFacility.isParkingLot() ? TermQuery.of(m -> m.field("common.keyword").value("PARKING_LOT"))._toQuery() : null;
        Query publicShower = commonFacility.isPublicShower() ? TermQuery.of(m -> m.field("common.keyword").value("PUBLIC_SHOWER"))._toQuery() : null;
        Query hotSpring = commonFacility.isHotSpring() ? TermQuery.of(m -> m.field("common.keyword").value("HOT_SPRING"))._toQuery() : null;
        Query skiResort = commonFacility.isSkiResort() ? TermQuery.of(m -> m.field("common.keyword").value("SKI_RESORT"))._toQuery() : null;
        Query makingFood = commonFacility.isMakingFood() ? TermQuery.of(m -> m.field("common.keyword").value("MAKING_FOOD"))._toQuery() : null;

        return Lists.newArrayList(
                        fitness,
                        swimmingPool,
                        sauna,
                        golfCourse,
                        restaurant,
                        elevator,
                        lounge,
                        publicPc,
                        bbq,
                        cafe,
                        publicSpa,
                        footballGround,
                        meetingRoom,
                        convenienceStore,
                        singingRoom,
                        kitchen,
                        washingMachine,
                        dryingMachine,
                        spinDryer,
                        parkingLot,
                        publicShower,
                        hotSpring,
                        skiResort,
                        makingFood
                ).stream().filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    public HotelDetail findHotelById(Long id) throws IOException {
        GetResponse<HotelDetail> response = client.get(g -> g
                        .index("hotel-detail")
                        .id(id.toString()),
                HotelDetail.class
        );

        if (response.found())
        {
            return response.source();
        } else
        {
            log.info ("HotelDetail not found");
        }
        return null;
    }

    public ReviewDto findReviewById(Long accoId) throws IOException
    {

        SearchResponse<ReviewDto> response = client.search(s -> s
                        .index("review")
                        .query(q -> q.match(
                                t ->t.field("accoId").query(accoId.toString())
                                ))
                ,
                ReviewDto.class
        );
        List<Hit<ReviewDto>> hits = response.hits().hits();
        ReviewDto reviewDto = null;
        for (Hit<ReviewDto> hit: hits)
        {
            reviewDto = hit.source();
            return reviewDto;
        }

        return null;
    }
}
