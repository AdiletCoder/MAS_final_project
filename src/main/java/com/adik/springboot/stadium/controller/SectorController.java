package com.adik.springboot.stadium.controller;

import com.adik.springboot.stadium.model.Game;
import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.model.Time;
import com.adik.springboot.stadium.repository.SectorRepository;
import com.adik.springboot.stadium.services.SectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class SectorController {
    private SectorService sectorService;
    private final SectorRepository sectorRepository;

    @RequestMapping("/list-stadiums/{stadium}/sectors")
    public String getSectorsByStadium(@PathVariable("stadium") Stadium stadium, Model model){
        List<Sector> sectors = sectorService.getSectorByStadium(stadium);
        model.addAttribute("sectors", sectors);
        return "listSectors";
    }

    @RequestMapping("list-sectors")
    public String listAllSectors(ModelMap model) {
        Iterable<Sector> sectors = sectorRepository.findAll();
        model.addAttribute("sectors", sectors);
        return "listSectors";
    }

    @RequestMapping("/list-times/{time}/sectors")
    public String getSectorsByTime(@PathVariable("time") Time time, Model model){
        List<Sector> sectors = sectorService.getSectorsByTime(time);
        model.addAttribute("sectors", sectors);
        return "listSectors";
    }
}
