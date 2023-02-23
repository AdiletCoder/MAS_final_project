package com.adik.springboot.stadium.repository;


import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.model.Time;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectorRepository extends CrudRepository<Sector, Long> {
    List<Sector> findSectorByStadium(Stadium stadium);
    List<Sector> findSectorByTime(Time time);
}
