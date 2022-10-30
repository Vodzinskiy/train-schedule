package io04.trainschedule.controllers;

import io04.trainschedule.models.Station;
import io04.trainschedule.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;



@Controller
public class AdminStationController {

    @Autowired
    StationService stationService;

    @GetMapping("/admin/station")
    public String adminStation(Model model){
        model.addAttribute("station",stationService.findAll().values().stream()
                .map(Station::toString)
                .collect(Collectors.joining(", ")));
        return "adminStation";
    }

    @GetMapping(value = "/admin/station", params = "add")
    public String add(String stationId, String stationName) {
        stationService.save(new Station(Integer.parseInt(stationId), stationName));
        return "redirect:/admin/station";
    }

    @GetMapping(value = "/admin/station", params = "delete")
    public String delete(String stationId) {
        stationService.delete(Integer.parseInt(stationId));
        return "redirect:/admin/station";
    }

    @GetMapping(value = "/admin/station", params = "edit")
    public String edit(String stationId, String stationName) {
        stationService.editName(Integer.parseInt(stationId), stationName);
        return "redirect:/admin/station";
    }
}
