package com.adik.springboot.stadium.repository;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeRepository extends JpaRepository<Time, Long> {
    List<Time> findByGame(Game game);
}
