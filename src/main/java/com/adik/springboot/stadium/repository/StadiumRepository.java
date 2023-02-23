package com.adik.springboot.stadium.repository;
import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
