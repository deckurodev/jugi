package com.jugi.jugi.accmodation.domain;

import com.jugi.jugi.accmodation.command.accommodation.domain.*;
import com.jugi.jugi.accmodation.command.accommodation.domain.type.BusinessType;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AccommodationInfoTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("숙박 정보 생성 성공 테스트")
    void accommodationInfoSaveTest()
    {
        Accommodation accommodation = AccommodationHelper.accommodation;

        List<AccommodationInfo> accommodationInfos = Lists.newArrayList(
                new AccommodationInfo(
                        "공지사항",
                        Lists.newArrayList(
                                new AccommodationInfoValue("객실 배정 시 욕실 타입은 욕조 or 샤워부스 중 랜덤으로 배정됩니다", 1),
                                new AccommodationInfoValue("장식 촛불 점화로 인한 재해 시 고객에게 귀책됨을 유념하시어 화재가 일어나지 않도록 각별한 주의를 당부드립니다", 2),
                                new AccommodationInfoValue("풍선 장식을 하고자 하는 고객께서는 되도록 1회용 헬륨가스를 구입하시어 사용하시고 테이프 부착은 불가합니다", 3)
                        ),
                        1
                ),
                new AccommodationInfo(
                        "투숙객 혜택",
                        Lists.newArrayList(
                                new AccommodationInfoValue("수영장 투숙객 2인 무료 이용", 1),
                                new AccommodationInfoValue("사우나 투숙객 50% 할인", 2)
                        ),
                        2
                )

        );

        accommodation.setAccommodationInfoList(accommodationInfos);

        Accommodation save = accommodationRepository.save(accommodation);

        assertThat(save.getAccommodationInfoList()).hasSize(2);

        List<AccommodationInfo> accommodationInfoList = save.getAccommodationInfoList();

        assertThat(accommodationInfoList).extracting(AccommodationInfo::getAttribute)
                .containsAll(List.of("공지사항", "투숙객 혜택"));
        assertThat(accommodationInfoList).flatExtracting(AccommodationInfo::getAccommodationInfoValueList)
                .containsAll(
                        Lists.newArrayList(
                                new AccommodationInfoValue("객실 배정 시 욕실 타입은 욕조 or 샤워부스 중 랜덤으로 배정됩니다", 1),
                                new AccommodationInfoValue("장식 촛불 점화로 인한 재해 시 고객에게 귀책됨을 유념하시어 화재가 일어나지 않도록 각별한 주의를 당부드립니다", 2),
                                new AccommodationInfoValue("풍선 장식을 하고자 하는 고객께서는 되도록 1회용 헬륨가스를 구입하시어 사용하시고 테이프 부착은 불가합니다", 3),
                                new AccommodationInfoValue("수영장 투숙객 2인 무료 이용", 1),
                                new AccommodationInfoValue("사우나 투숙객 50% 할인", 2)
                        )
                );

    }

    @Test
    @DisplayName("숙소 정보 상세 생성시 중복되는 순서가 있으면 에러 던진다.")
    void accommodationInfoCreateFailTest()
    {
        Assertions.assertThatThrownBy(() -> new AccommodationInfo(
                "공지사항",
                Lists.newArrayList(
                        new AccommodationInfoValue("객실 배정 시 욕실 타입은 욕조 or 샤워부스 중 랜덤으로 배정됩니다", 1),
                        new AccommodationInfoValue("장식 촛불 점화로 인한 재해 시 고객에게 귀책됨을 유념하시어 화재가 일어나지 않도록 각별한 주의를 당부드립니다", 1),
                        new AccommodationInfoValue("풍선 장식을 하고자 하는 고객께서는 되도록 1회용 헬륨가스를 구입하시어 사용하시고 테이프 부착은 불가합니다", 3)
                ),
                1
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 순서가 있습니다.");
    }

    public static List<AccommodationInfo> given1()
    {
        return Lists.newArrayList(
                new AccommodationInfo(
                        "기본사항",
                        Lists.newArrayList(
                                new AccommodationInfoValue("체크인 : 14:00 | 체크아웃 : 12:00", 1),
                                new AccommodationInfoValue("무료 Wi-Fi", 2),
                                new AccommodationInfoValue("전 객실 금연", 3),
                                new AccommodationInfoValue("Bath Amenity (칫솔, 치약의 경우 프론트에서 구매 가능)", 4),
                                new AccommodationInfoValue("유료 주차 (객실 당 1대 / 박당 10,000원)", 5),
                                new AccommodationInfoValue("주차 가능 객실 상품에 한하며, 주차 불가 상품 이용 시 '주차 불가'", 6),
                                new AccommodationInfoValue("주차장 협소로 만차 시 외부 주차장(고객부담)으로 안내해 드리니 많은 양해 부탁드립니다", 7, true, "red")
                        )
                        , 1
                ),

                new AccommodationInfo(
                        "객실 안내",
                        Lists.newArrayList(
                                new AccommodationInfoValue("스탠다드 객실 타입 : 중앙 냉/난방 시스템", 1)
                        ),
                        2
                ),

                new AccommodationInfo(
                        "투숙객 혜택",
                        Lists.newArrayList(
                                new AccommodationInfoValue("피트니스 센터 투숙객 무료", 1)
                        ),
                        3
                ),

                new AccommodationInfo(
                        "부대시설",
                        Lists.newArrayList(
                                new AccommodationInfoValue("Fresh 365 Dining (레스토랑) / 2층 / 월~일 뷔페 07:00~10:00 / 월~토 단품 12:00~14:30 (런치), 18:00~22:00 (디너, 라스트 오더 21:00)", 1),
                                new AccommodationInfoValue("다이닝 올리브 & 오키드 (레스토랑) / 2층 / 12:00~15:00 (중식), 19:00~22:00 (석식)", 2),
                                new AccommodationInfoValue("Le Café (카페) / 로비 / 00:00~24:00", 3),
                                new AccommodationInfoValue("Le Bar (Bar) / 2층 / 월~토 운영 / 12:00~18:00 (카페) / 18:00~22:00 (Bar, 라스트 오더 21:00)", 4),
                                new AccommodationInfoValue("비즈니스 센터 / 로비 / 00:00~24:00", 5),
                                new AccommodationInfoValue("피트니스 센터 / 지하 1층 / 06:00~21:00 (운영 중)", 6)
                        ),
                        4
                ),


                new AccommodationInfo(
                        "현장 추가 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("전 객실 인원 추가 불가", 1, true, "red")
                        ),
                        5
                ),


                new AccommodationInfo(
                        "조식 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("Fresh 365 Dining 레스토랑 / 2층 / (월~일) 07:00~10:00", 1),
                                new AccommodationInfoValue("사전 예약(결제) : 16,500원 / 현장 결제 : 1인 22,000원 (14세 이상~성인), 9,900원 (48개월 이상~13세 이하), 48개월 미만 무료", 2),
                                new AccommodationInfoValue("조식 요금 인상 (23년 3월 31일부로~) ", 3),
                                new AccommodationInfoValue("사전 예약(결제) : 19,800원 / 현장 결제 : 1인 26,000원 (14세 이상~성인), 13,200원 (48개월 이상~13세 이하), 48개월 미만 무료", 4)
                        ),
                        6
                ),



                new AccommodationInfo(
                        "취소 및 환불 규정",
                        Lists.newArrayList(
                                new AccommodationInfoValue("체크인일 기준 1일 전까지 : 100% 환불", 1),
                                new AccommodationInfoValue("체크인일 기준 당일 및 No-show : 환불 불가", 2),
                                new AccommodationInfoValue("취소, 환불시 수수료가 발생할 수 있습니다", 3),
                                new AccommodationInfoValue("아래 객실은 별도의 취소 규정이 적용되오니 참고 부탁드립니다", 4, true, "red"),
                                new AccommodationInfoValue("[Co-living 패키지-소이프 디자인 양말], [Co-living 패키지-호랑이 머플러] 객실 : 취소, 변경, 환불 불가", 5)
                        ),
                        7
                ),

                new AccommodationInfo(
                        "확인사항 및 기타",
                        Lists.newArrayList(
                                new AccommodationInfoValue("최대 인원 초과시 입실 불가합니다", 1),
                                new AccommodationInfoValue("위의 정보는 호텔의 사정에 따라 변경될 수 있습니다", 2),
                                new AccommodationInfoValue("해당 이미지는 실제와 상이 할 수 있습니다", 3),
                                new AccommodationInfoValue("체크인 시 배정 또는 베드 타입 미기재 상품은 특정 객실과 베드타입을 보장하지 않습니다", 4),
                                new AccommodationInfoValue("해당 객실가는 세금, 봉사료가 포함된 금액입니다", 5),
                                new AccommodationInfoValue("미성년자는 보호자 동반없이 이용하실 수 없습니다", 6)
                        ),
                        8
                )
        );
    }

    public static List<AccommodationInfo> given2()
    {
        return Lists.newArrayList(
                new AccommodationInfo(
                        "기본 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("체크인 : 15:00 | 체크아웃 : 12:00", 1),
                                new AccommodationInfoValue("무료 Wi-Fi", 2),
                                new AccommodationInfoValue("전 객실 금연", 3),
                                new AccommodationInfoValue("Bath Amenity (치약, 칫솔 유료)", 4),
                                new AccommodationInfoValue("주차 가능 (무료 / 객실 당 1대)", 5)
                        )
                        , 1
                ),

                new AccommodationInfo(
                        "인원 추가 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("전 객실 인원추가 불가", 1, true, "red")
                        ),
                        2
                ),

                new AccommodationInfo(
                        "투숙객 혜택",
                        Lists.newArrayList(
                                new AccommodationInfoValue("비즈니스 센터 : 투숙객 무료", 1)
                        ),
                        3
                ),

                new AccommodationInfo(
                        "부대시설",
                        Lists.newArrayList(
                                new AccommodationInfoValue("비즈니스 센터 / 1층 로비 / 24시간", 1)
                        ),
                        4
                ),


                new AccommodationInfo(
                        "취사 시설",
                        Lists.newArrayList(
                                new AccommodationInfoValue("전 객실 취사 불가", 1)
                        ),
                        5
                ),


                new AccommodationInfo(
                        "취소 및 환불 규정",
                        Lists.newArrayList(
                                new AccommodationInfoValue("체크인 기준 1일 전 : 100% 환불", 1),
                                new AccommodationInfoValue("체크인 당일 및 No-show : 환불불가", 2),
                                new AccommodationInfoValue("취소, 환불시 수수료가 발생할 수 있습니다.", 3),
                                new AccommodationInfoValue("[선착순특가] 객실 : 예약 후 취소, 변경, 환불불가", 4, false, "red")
                        ),
                        6
                ),



                new AccommodationInfo(
                        "확인사항 및 기타",
                        Lists.newArrayList(
                                new AccommodationInfoValue("최대인원 초과시 입실 불가합니다", 1),
                                new AccommodationInfoValue("위의 정보는 호텔의 사정에 따라 변경될 수 있습니다", 2),
                                new AccommodationInfoValue("해당 이미지는 실제와 상이 할 수 있습니다", 3),
                                new AccommodationInfoValue("체크인 시 배정 또는 베드타입 미기재 상품은 특정객실과 베드타입을 보장하지 않습니다", 4, true, "red"),
                                new AccommodationInfoValue("해당 객실가는 세금, 봉사료가 포함된 금액입니다", 5),
                                new AccommodationInfoValue("미성년자는 보호자 동반없이 이용하실 수 없습니다", 6)
                        ),
                        7
                )
        );
    }

    static List<AccommodationInfo> given3()
    {
        return Lists.newArrayList(
                new AccommodationInfo(
                        "기본 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("체크인 : 15:00 | 체크아웃 : 12:00", 1),
                                new AccommodationInfoValue("무료 Wi-Fi", 2),
                                new AccommodationInfoValue("22시 이후 체크인 시 호텔 프론트 문의", 3),
                                new AccommodationInfoValue("Bath Amenity (치약, 칫솔 유료)", 4),
                                new AccommodationInfoValue("주차 가능 (무료)", 5),
                                new AccommodationInfoValue("전 객실 금연", 6)
                        )
                        , 1
                ),

                new AccommodationInfo(
                        "인원 추가 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("기준인원 외 추가 시, 1인 10,000원 (침구 포함)", 1),
                                new AccommodationInfoValue("침구 추가 : 1채당 10,000원", 2),
                                new AccommodationInfoValue("영유아 인원수 포함 / 최대인원 초과 불가", 3),
                                new AccommodationInfoValue("현장 결제", 4)
                        ),
                        2
                ),

                new AccommodationInfo(
                        "부대시설 정보",
                        Lists.newArrayList(
                                new AccommodationInfoValue("북카페 / 1층 / 09:00~17:00 / 주말, 성수기 유동적", 1),
                                new AccommodationInfoValue("만해 문학박물관 / 만해마을 내 / 09:00~17:00 / 투숙객 무료", 2),
                                new AccommodationInfoValue("운동장 / 만해마을 내 / 09:00~17:00 / 투숙객 무료", 3)
                        ),
                        3
                ),

                new AccommodationInfo(
                        "취사 시설",
                        Lists.newArrayList(
                                new AccommodationInfoValue("전 객실 취사 불가", 1)
                        ),
                        4
                ),


                new AccommodationInfo(
                        "취소 및 환불 규정",
                        Lists.newArrayList(
                                new AccommodationInfoValue("체크인일 기준 1일전 24시까지 : 100% 환불", 1),
                                new AccommodationInfoValue("체크인일 기준 당일 및 No-show : 환불불가", 2),
                                new AccommodationInfoValue("취소, 환불 시 수수료가 발생할 수 있습니다", 3)
                        ),
                        5
                ),


                new AccommodationInfo(
                        "확인사항 및 기타",
                        Lists.newArrayList(
                                new AccommodationInfoValue("미성년자는 보호자 동반없이 이용이 불가합니다", 1),
                                new AccommodationInfoValue("위의 정보는 호텔의 사정에 따라 변경될 수 있습니다", 2),
                                new AccommodationInfoValue("해당 이미지는 실제와 상이 할 수 있습니다", 3),
                                new AccommodationInfoValue("체크인 시 배정 또는 베드 타입 미기재 상품은 특정객실과 베드 타입을 보장하지 않습니다", 4),
                                new AccommodationInfoValue("해당 객실가는 세금, 봉사료가 포함된 금액입니다", 5)
                        ),
                        6
                )
        );
    }


    List<AccommodationInfo> accommodationInfos1 = Lists.newArrayList(
            new AccommodationInfo(
                    "기본사항",
                    Lists.newArrayList(
                            new AccommodationInfoValue("체크인 : 14:00 | 체크아웃 : 12:00", 1),
                            new AccommodationInfoValue("무료 Wi-Fi", 2),
                            new AccommodationInfoValue("전 객실 금연", 3),
                            new AccommodationInfoValue("Bath Amenity (칫솔, 치약의 경우 프론트에서 구매 가능)", 4),
                            new AccommodationInfoValue("유료 주차 (객실 당 1대 / 박당 10,000원)", 5),
                            new AccommodationInfoValue("주차 가능 객실 상품에 한하며, 주차 불가 상품 이용 시 '주차 불가'", 6),
                            new AccommodationInfoValue("주차장 협소로 만차 시 외부 주차장(고객부담)으로 안내해 드리니 많은 양해 부탁드립니다", 7, true, "red")
                    )
                    , 1
            ),

            new AccommodationInfo(
                    "객실 안내",
                    Lists.newArrayList(
                            new AccommodationInfoValue("스탠다드 객실 타입 : 중앙 냉/난방 시스템", 1)
                    ),
                    2
            ),

            new AccommodationInfo(
                    "투숙객 혜택",
                    Lists.newArrayList(
                            new AccommodationInfoValue("피트니스 센터 투숙객 무료", 1)
                    ),
                    3
            ),

            new AccommodationInfo(
                    "부대시설",
                    Lists.newArrayList(
                            new AccommodationInfoValue("Fresh 365 Dining (레스토랑) / 2층 / 월~일 뷔페 07:00~10:00 / 월~토 단품 12:00~14:30 (런치), 18:00~22:00 (디너, 라스트 오더 21:00)", 1),
                            new AccommodationInfoValue("다이닝 올리브 & 오키드 (레스토랑) / 2층 / 12:00~15:00 (중식), 19:00~22:00 (석식)", 2),
                            new AccommodationInfoValue("Le Café (카페) / 로비 / 00:00~24:00", 3),
                            new AccommodationInfoValue("Le Bar (Bar) / 2층 / 월~토 운영 / 12:00~18:00 (카페) / 18:00~22:00 (Bar, 라스트 오더 21:00)", 4),
                            new AccommodationInfoValue("비즈니스 센터 / 로비 / 00:00~24:00", 5),
                            new AccommodationInfoValue("피트니스 센터 / 지하 1층 / 06:00~21:00 (운영 중)", 6)
                    ),
                    4
            ),


            new AccommodationInfo(
                    "현장 추가 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("전 객실 인원 추가 불가", 1, true, "red")
                    ),
                    5
            ),


            new AccommodationInfo(
                    "조식 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("Fresh 365 Dining 레스토랑 / 2층 / (월~일) 07:00~10:00", 1),
                            new AccommodationInfoValue("사전 예약(결제) : 16,500원 / 현장 결제 : 1인 22,000원 (14세 이상~성인), 9,900원 (48개월 이상~13세 이하), 48개월 미만 무료", 2),
                            new AccommodationInfoValue("조식 요금 인상 (23년 3월 31일부로~) ", 3),
                            new AccommodationInfoValue("사전 예약(결제) : 19,800원 / 현장 결제 : 1인 26,000원 (14세 이상~성인), 13,200원 (48개월 이상~13세 이하), 48개월 미만 무료", 4)
                    ),
                    6
            ),



            new AccommodationInfo(
                    "취소 및 환불 규정",
                    Lists.newArrayList(
                            new AccommodationInfoValue("체크인일 기준 1일 전까지 : 100% 환불", 1),
                            new AccommodationInfoValue("체크인일 기준 당일 및 No-show : 환불 불가", 2),
                            new AccommodationInfoValue("취소, 환불시 수수료가 발생할 수 있습니다", 3),
                            new AccommodationInfoValue("아래 객실은 별도의 취소 규정이 적용되오니 참고 부탁드립니다", 4, true, "red"),
                            new AccommodationInfoValue("[Co-living 패키지-소이프 디자인 양말], [Co-living 패키지-호랑이 머플러] 객실 : 취소, 변경, 환불 불가", 5)
                    ),
                    7
            ),

            new AccommodationInfo(
                    "확인사항 및 기타",
                    Lists.newArrayList(
                            new AccommodationInfoValue("최대 인원 초과시 입실 불가합니다", 1),
                            new AccommodationInfoValue("위의 정보는 호텔의 사정에 따라 변경될 수 있습니다", 2),
                            new AccommodationInfoValue("해당 이미지는 실제와 상이 할 수 있습니다", 3),
                            new AccommodationInfoValue("체크인 시 배정 또는 베드 타입 미기재 상품은 특정 객실과 베드타입을 보장하지 않습니다", 4),
                            new AccommodationInfoValue("해당 객실가는 세금, 봉사료가 포함된 금액입니다", 5),
                            new AccommodationInfoValue("미성년자는 보호자 동반없이 이용하실 수 없습니다", 6)
                    ),
                    8
            )
    );

    List<AccommodationInfo> accommodationInfos2 = Lists.newArrayList(
            new AccommodationInfo(
                    "기본 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("체크인 : 15:00 | 체크아웃 : 12:00", 1),
                            new AccommodationInfoValue("무료 Wi-Fi", 2),
                            new AccommodationInfoValue("전 객실 금연", 3),
                            new AccommodationInfoValue("Bath Amenity (치약, 칫솔 유료)", 4),
                            new AccommodationInfoValue("주차 가능 (무료 / 객실 당 1대)", 5)
                    )
                    , 1
            ),

            new AccommodationInfo(
                    "인원 추가 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("전 객실 인원추가 불가", 1, true, "red")
                    ),
                    2
            ),

            new AccommodationInfo(
                    "투숙객 혜택",
                    Lists.newArrayList(
                            new AccommodationInfoValue("비즈니스 센터 : 투숙객 무료", 1)
                    ),
                    3
            ),

            new AccommodationInfo(
                    "부대시설",
                    Lists.newArrayList(
                            new AccommodationInfoValue("비즈니스 센터 / 1층 로비 / 24시간", 1)
                    ),
                    4
            ),


            new AccommodationInfo(
                    "취사 시설",
                    Lists.newArrayList(
                            new AccommodationInfoValue("전 객실 취사 불가", 1)
                    ),
                    5
            ),


            new AccommodationInfo(
                    "취소 및 환불 규정",
                    Lists.newArrayList(
                            new AccommodationInfoValue("체크인 기준 1일 전 : 100% 환불", 1),
                            new AccommodationInfoValue("체크인 당일 및 No-show : 환불불가", 2),
                            new AccommodationInfoValue("취소, 환불시 수수료가 발생할 수 있습니다.", 3),
                            new AccommodationInfoValue("[선착순특가] 객실 : 예약 후 취소, 변경, 환불불가", 4, false, "red")
                    ),
                    6
            ),



            new AccommodationInfo(
                    "확인사항 및 기타",
                    Lists.newArrayList(
                            new AccommodationInfoValue("최대인원 초과시 입실 불가합니다", 1),
                            new AccommodationInfoValue("위의 정보는 호텔의 사정에 따라 변경될 수 있습니다", 2),
                            new AccommodationInfoValue("해당 이미지는 실제와 상이 할 수 있습니다", 3),
                            new AccommodationInfoValue("체크인 시 배정 또는 베드타입 미기재 상품은 특정객실과 베드타입을 보장하지 않습니다", 4, true, "red"),
                            new AccommodationInfoValue("해당 객실가는 세금, 봉사료가 포함된 금액입니다", 5),
                            new AccommodationInfoValue("미성년자는 보호자 동반없이 이용하실 수 없습니다", 6)
                    ),
                    7
            )
    );

    List<AccommodationInfo> accommodationInfos3 = Lists.newArrayList(
            new AccommodationInfo(
                    "기본 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("체크인 : 15:00 | 체크아웃 : 12:00", 1),
                            new AccommodationInfoValue("무료 Wi-Fi", 2),
                            new AccommodationInfoValue("22시 이후 체크인 시 호텔 프론트 문의", 3),
                            new AccommodationInfoValue("Bath Amenity (치약, 칫솔 유료)", 4),
                            new AccommodationInfoValue("주차 가능 (무료)", 5),
                            new AccommodationInfoValue("전 객실 금연", 6)
                    )
                    , 1
            ),

            new AccommodationInfo(
                    "인원 추가 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("기준인원 외 추가 시, 1인 10,000원 (침구 포함)", 1),
                            new AccommodationInfoValue("침구 추가 : 1채당 10,000원", 2),
                            new AccommodationInfoValue("영유아 인원수 포함 / 최대인원 초과 불가", 3),
                            new AccommodationInfoValue("현장 결제", 4)
                    ),
                    2
            ),

            new AccommodationInfo(
                    "부대시설 정보",
                    Lists.newArrayList(
                            new AccommodationInfoValue("북카페 / 1층 / 09:00~17:00 / 주말, 성수기 유동적", 1),
                            new AccommodationInfoValue("만해 문학박물관 / 만해마을 내 / 09:00~17:00 / 투숙객 무료", 2),
                            new AccommodationInfoValue("운동장 / 만해마을 내 / 09:00~17:00 / 투숙객 무료", 3)
                    ),
                    3
            ),

            new AccommodationInfo(
                    "취사 시설",
                    Lists.newArrayList(
                            new AccommodationInfoValue("전 객실 취사 불가", 1)
                    ),
                    4
            ),


            new AccommodationInfo(
                    "취소 및 환불 규정",
                    Lists.newArrayList(
                            new AccommodationInfoValue("체크인일 기준 1일전 24시까지 : 100% 환불", 1),
                            new AccommodationInfoValue("체크인일 기준 당일 및 No-show : 환불불가", 2),
                            new AccommodationInfoValue("취소, 환불 시 수수료가 발생할 수 있습니다", 3)
                    ),
                    5
            ),


            new AccommodationInfo(
                    "확인사항 및 기타",
                    Lists.newArrayList(
                            new AccommodationInfoValue("미성년자는 보호자 동반없이 이용이 불가합니다", 1),
                            new AccommodationInfoValue("위의 정보는 호텔의 사정에 따라 변경될 수 있습니다", 2),
                            new AccommodationInfoValue("해당 이미지는 실제와 상이 할 수 있습니다", 3),
                            new AccommodationInfoValue("체크인 시 배정 또는 베드 타입 미기재 상품은 특정객실과 베드 타입을 보장하지 않습니다", 4),
                            new AccommodationInfoValue("해당 객실가는 세금, 봉사료가 포함된 금액입니다", 5)
                    ),
                    6
            )
    );

    @Test
    @Commit
    @DisplayName("info 초기화용")
    void initTest()
    {

        List<Accommodation> all = accommodationRepository.findAll();

        for (Accommodation accommodation : all)
        {
            List<List<AccommodationInfo>> infos = Lists.newArrayList(
                    given1(),
                    given2(),
                    given3()
            );

            if (accommodation.getBusinessType() == BusinessType.HOTEL)
            {
                System.out.println(accommodation.getBusinessType() + " 입력!!");
                int index = (int) (Math.random() * 3);
                List<AccommodationInfo> accommodationInfos = infos.get(index);
                accommodation.setAccommodationInfoList(accommodationInfos);

                for (AccommodationInfo accommodationInfo : accommodationInfos)
                {
                    accommodationInfo.setAccommodation(accommodation);
                }
            }
        }


    }
}