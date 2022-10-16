package io04.trainschedule.controllers;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Train;
import io04.trainschedule.services.StationService;
import io04.trainschedule.services.TrainFinderService;
import io04.trainschedule.services.implementation.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String mainHtml(){
        return "index";
    }

    @Autowired
    TrainFinderService trainFinderService;

    @Autowired
    TrainServiceImpl trainService;

    @Autowired
    StationService stationService;



    @GetMapping("/trains")
    public String trains(
            @RequestParam(name = "stationOfDeparture") String stationOfDeparture,
            @RequestParam(name = "stationOfArrival") String stationOfArrival,
            @RequestParam(name = "dateTime") String dateTime,
            Model model){

        List<Train> trains = trainFinderService.getSuitableTrain(stationService.findByName(stationOfDeparture), stationService.findByName(stationOfArrival), DataTime.stringToDataTime(dateTime));

        return trains.toString();
    }


    @GetMapping("/admin")
    public String adminHtml(){
        return "admin";
    }
}
