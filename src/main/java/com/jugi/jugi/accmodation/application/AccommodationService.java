package com.jugi.jugi.accmodation.application;

import com.jugi.jugi.accmodation.domain.Accommodation;
import com.jugi.jugi.accmodation.domain.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public List<Accommodation> findAll()
    {
        return accommodationRepository.findAll();
    }
}
