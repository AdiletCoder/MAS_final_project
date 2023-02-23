package com.adik.springboot.stadium.controller;
import java.util.List;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    private GameService gameService;
    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    @RequestMapping("list-games")
    public String listAllGames(ModelMap model) {
        List<Game> games = gameService.getGames();
        model.addAttribute("games", games);
        return "listGames";
    }
}
