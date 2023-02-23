package com.adik.springboot.stadium.repository;

import com.adik.springboot.stadium.model.Seat;
import com.adik.springboot.stadium.model.Sector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    List<Seat> findAllSeatBySector(Sector sector);

    Seat findSeatBySeatNumber(int seatNumber);
}
