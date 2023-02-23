package com.adik.springboot.stadium.controller;

import com.adik.springboot.stadium.model.Seat;
import com.adik.springboot.stadium.model.Sector;
import com.adik.springboot.stadium.model.Stadium;
import com.adik.springboot.stadium.services.SeatService;
import com.adik.springboot.stadium.services.SectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class SeatController {

    private SeatService seatService;
    private SectorService sectorService;

    @RequestMapping("/list-stadiums/{stadium}/sectors/{sector}/seats")
    public String getSeatsBySector(@PathVariable("stadium") Stadium stadium, @PathVariable("sector") Sector sector, Model model){
        List<Sector> sectors = sectorService.getSectorByStadium(stadium);
        List<Seat> seats = seatService.getSeatsBySector(sector);
        model.addAttribute("sectors", sectors);
        model.addAttribute("seats", seats);
        return "listSeats";
    }

    @RequestMapping("/list-stadiums/{stadium}/sectors/{sector}/seats/{seat}")
    public String getSeatsByNumber(@PathVariable("stadium") Stadium stadium, @PathVariable("sector") Sector sector, @PathVariable("seat") Seat seat, Model model){
        Seat seatNumber = seatService.getSeatNumber(seat.getSeatNumber());
        model.addAttribute("seatNumber", seatNumber);
        return "confirmation";
    }
}
