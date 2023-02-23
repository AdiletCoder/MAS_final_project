package com.adik.springboot.stadium.repository;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Time;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    public List<Game> findAll();
}
