package com.jugi.jugi.accmodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Table(name = "acco_info")
@Entity
@NoArgsConstructor
public class AccommodationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acco_info_id")
    private Long id;

    private String attribute;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "acco_value_info", joinColumns = @JoinColumn(name = "acco_info_id"))
    private List<AccommodationInfoValue> accommodationInfoValueList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acco_id")
    private Accommodation accommodation;

    public AccommodationInfo(String attribute, List<AccommodationInfoValue> accommodationInfoValueList)
    {
        this.attribute = attribute;

        long count = accommodationInfoValueList.stream().map(AccommodationInfoValue::getDisplayOrder).distinct().count();

        if (count  != accommodationInfoValueList.size())
        {
            throw new IllegalArgumentException("중복되는 순서가 있습니다.");
        }

        this.accommodationInfoValueList = accommodationInfoValueList;
    }
}