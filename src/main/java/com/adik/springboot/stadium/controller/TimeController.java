package com.adik.springboot.stadium.controller;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.model.Time;
import com.adik.springboot.stadium.repository.TimeRepository;
import com.adik.springboot.stadium.services.GameService;
import com.adik.springboot.stadium.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TimeController {

    @Autowired
    private TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @RequestMapping ("/list-games/{game}/times")
    public String getTimesForGame(@PathVariable("game") Game game, Model model){
        List<Time> times = timeService.getTimesByGame(game);
        model.addAttribute("times", times);
        return "listTimes";
    }

    @RequestMapping("list-matches")
    public String listAllTimes(ModelMap model) {
        Iterable<Time> times = timeService.getTimes();
        model.addAttribute("times", times);
        return "listTimes";
    }
}
