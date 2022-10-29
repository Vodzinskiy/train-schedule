package io04.trainschedule.controllers;


import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Train;
import io04.trainschedule.services.StationService;
import io04.trainschedule.services.TrainFinderService;

import io04.trainschedule.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    TrainFinderService trainFinderService;

    @Autowired
    StationService stationService;

    @Autowired
    TrainService trainService;

    @GetMapping("/")
    public String mainHtml(Model model){



        model.addAttribute("trains", trainService.findAll().values());
        return "index";
    }


    @GetMapping("/trains")
    public String trains (
           String stationOfDeparture,
           String stationOfArrival,
           String dateTime,
            Model model){
        List<Train> trains = trainFinderService.getSuitableTrain(stationService.findByName(stationOfDeparture), stationService.findByName(stationOfArrival), DataTime.stringToDataTime(dateTime));
        model.addAttribute("trains", trains);
        System.out.println(trains);
        return "index";
    }

    @GetMapping("/trains/{id}")
    public String train(@PathVariable String id, Model model) {
        Train train = trainService.findById(Integer.parseInt(id));
        model.addAttribute("trainStations", train.getSortedStations());
        return "train";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
