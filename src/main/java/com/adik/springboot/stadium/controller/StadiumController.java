package com.adik.springboot.stadium.controller;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.repository.StadiumRepository;
import com.adik.springboot.stadium.services.StadiumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StadiumController {
    private StadiumRepository stadiumRepository;
    private StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }
    @RequestMapping("list-stadiums")
    public String listAllStadiums(ModelMap model){
        Iterable<Stadium> stadiums = stadiumService.getStadiums();
        model.addAttribute("stadiums", stadiums);
        return "listStadiums";
    }
}
