package com.adik.springboot.stadium.services;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.model.Time;
import com.adik.springboot.stadium.repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorRepository sectorRepository;

    public List<Sector> getSectorByStadium(Stadium stadium){
        return sectorRepository.findSectorByStadium(stadium);
    }

    public List<Sector> getSectorsByTime(Time time){
        return sectorRepository.findSectorByTime(time);
    }
}
