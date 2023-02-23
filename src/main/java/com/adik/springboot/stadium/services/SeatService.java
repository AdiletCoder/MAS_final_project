package com.adik.springboot.stadium.services;


import com.adik.springboot.stadium.model.Seat;
import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public List<Seat> getSeatsBySector(Sector sector){
        return seatRepository.findAllSeatBySector(sector);
    }
    public Seat getSeatNumber(int seatNumber){
        return seatRepository.findSeatBySeatNumber(seatNumber);
    }
}
