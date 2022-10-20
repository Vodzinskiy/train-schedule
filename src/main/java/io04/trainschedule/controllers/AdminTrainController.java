package io04.trainschedule.controllers;

import io04.trainschedule.models.Station;
import io04.trainschedule.services.StationService;
import io04.trainschedule.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AdminTrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    @GetMapping("/admin/train")
    public String adminTrain(Model model) {
        ArrayList<String> temp = new ArrayList<>();
        for (Station station: stationService.findAll().values()) {
            temp.add(station.getName());
        }

        model.addAttribute("train", trainService.findAll().toString());
        model.addAttribute("stations", temp);
        return "adminTrain";
    }

    @GetMapping(value = "/admin/train", params = "delete")
    public String delete(String trainId) {
        trainService.delete(Integer.parseInt(trainId));
        return "redirect:/admin/train";
    }
}
