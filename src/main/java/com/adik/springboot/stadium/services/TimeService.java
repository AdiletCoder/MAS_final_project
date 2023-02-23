package com.adik.springboot.stadium.services;


import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Time;
import com.adik.springboot.stadium.repository.GameRepository;
import com.adik.springboot.stadium.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeService {
    private final TimeRepository timeRepository;

    public List<Time> getTimesByGame(Game game) {
        return timeRepository.findByGame(game);
    }
    public List<Time> getTimes(){
        return timeRepository.findAll();
    }

}
