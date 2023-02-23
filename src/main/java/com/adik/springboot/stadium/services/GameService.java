package com.adik.springboot.stadium.services;


import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> getGames(){
        return gameRepository.findAll();
    }
}

