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
        model.addAttribute("trains", trainService.findAll().toString());
        return "index";
    }


    @GetMapping("/trains")
    public String trains(
           String stationOfDeparture,
           String stationOfArrival,
           String dateTime,
            Model model){

        List<Train> trains = trainFinderService.getSuitableTrain(stationService.findByName(stationOfDeparture), stationService.findByName(stationOfArrival), DataTime.stringToDataTime(dateTime));
        StringBuilder res=new StringBuilder();
        for(Train train : trains) {
            res.append(train.toString());
            res.append(" відправляється з станції ")
                    .append(stationOfDeparture).append(" ")
                    .append(train.getArrivalStations().get(stationService.findByName(stationOfDeparture)).get(1).toString().replaceAll(":0",":00"))
                    .append("\n");
        }
        model.addAttribute("trains", res.toString());
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

}
