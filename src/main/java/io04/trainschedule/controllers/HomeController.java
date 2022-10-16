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
           String stationOfDeparture,
           String stationOfArrival,
           String dateTime,
            Model model){
//        String stationOfDeparture = "Вінниця";
//        String stationOfArrival = "Київ";
//        String dateTime = "19:30 15:10";


        List<Train> trains = trainFinderService.getSuitableTrain(stationService.findByName(stationOfDeparture), stationService.findByName(stationOfArrival), DataTime.stringToDataTime(dateTime));
        model.addAttribute("stationOfDeparture", stationOfDeparture);
        model.addAttribute("stationOfArrival", stationOfArrival);
        model.addAttribute("dateTime", dateTime);
        model.addAttribute("trains", trains);
        return "trains";
    }


    @GetMapping("/admin")
    public String adminHtml(){
        return "admin";
    }
}
