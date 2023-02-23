package com.adik.springboot.stadium.services;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StadiumService {
    private final StadiumRepository stadiumRepository;

    public List<Stadium> getStadiums(){
        return stadiumRepository.findAll();
    }
}
