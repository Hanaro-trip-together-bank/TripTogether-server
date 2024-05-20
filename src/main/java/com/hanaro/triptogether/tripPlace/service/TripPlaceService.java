package com.hanaro.triptogether.tripPlace.service;

import com.hanaro.triptogether.exception.ApiException;
import com.hanaro.triptogether.exception.ExceptionEnum;
import com.hanaro.triptogether.tripPlace.domain.TripPlace;
import com.hanaro.triptogether.tripPlace.domain.TripPlaceRepository;
import com.hanaro.triptogether.tripPlace.dto.response.TripPlaceResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TripPlaceService {
    private final TripPlaceRepository tripPlaceRepository;

    public List<TripPlaceResDto> getPlace(Long trip_idx) {
        List<TripPlace> tripPlaces = tripPlaceRepository.findAllByTrip_TripIdxOrderByTripDateAscPlaceOrderAsc(trip_idx);
        return tripPlaces.stream().map(TripPlaceResDto::new).toList();
    }

    public void deleteTripPlace(Long trip_place_idx) {
        checkTripPlaceExists(trip_place_idx);
        tripPlaceRepository.deleteById(trip_place_idx);
    }

    public void checkTripPlaceExists(Long trip_place_idx){
        tripPlaceRepository.findById(trip_place_idx).orElseThrow(() -> new ApiException(ExceptionEnum.TRIP_PLACE_NOT_FOUND));
    }
}