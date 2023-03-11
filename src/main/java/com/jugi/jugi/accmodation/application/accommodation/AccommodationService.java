package com.jugi.jugi.accmodation.application.accommodation;

import com.jugi.jugi.accmodation.command.accommodation.domain.Accommodation;
import com.jugi.jugi.accmodation.command.accommodation.domain.AccommodationRepository;
import com.jugi.jugi.accmodation.global.Exception.CustomException;
import com.jugi.jugi.accmodation.global.Exception.ErrorCode;
import com.jugi.jugi.accmodation.web.dto.AccommodationDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    // TODO
    public AccommodationDetailResponse searchById(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_HOTEL_ID));
        return AccommodationDetailResponse.toResponse(accommodation);
    }
}
