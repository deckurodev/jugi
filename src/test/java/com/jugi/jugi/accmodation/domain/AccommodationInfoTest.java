package com.jugi.jugi.accmodation.domain;

import com.jugi.jugi.accmodation.command.accommodation.domain.Accommodation;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationInfo;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationInfoValue;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AccommodationInfoTest {

    @Autowired
    AccommodationRepository accommodationRepository;

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
                        )
                ),
                new AccommodationInfo(
                        "투숙객 혜택",
                        Lists.newArrayList(
                                new AccommodationInfoValue("수영장 투숙객 2인 무료 이용", 1),
                                new AccommodationInfoValue("사우나 투숙객 50% 할인", 2)
                        )
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
                )
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 순서가 있습니다.");
    }

}