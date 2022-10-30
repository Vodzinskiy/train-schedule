package io04.trainschedule.controllers;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;
import io04.trainschedule.services.StationService;
import io04.trainschedule.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class AdminTrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    private HashMap<Station, ArrayList<DataTime>> stations = new HashMap<>();

    @GetMapping("/admin/train")
    public String adminTrain(Model model) {
        ArrayList<String> temp = new ArrayList<>();
        for (Station station: stationService.findAll().values()) {
            temp.add(station.getName());
        }

        model.addAttribute("trainsName", trainService.findAll().values().toString().replaceAll("[\\[\\]]",""));
        model.addAttribute("stations", temp);
        model.addAttribute("trains",trainService.findAll().values());
        return "adminTrain";
    }

    @GetMapping(value = "/admin/train", params = "delete")
    public String delete(String trainId) {
        if (!trainId.equals("")) {
            trainService.delete(Integer.parseInt(trainId));
        }
        return "redirect:/admin/train";
    }

    @GetMapping(value = "/admin/train", params = "add")
    public String add(String trainId, String trainName) {
        if (!trainId.equals("") && !trainName.equals("")) {
            stations = new HashMap<>();
            trainService.save(new Train(Integer.parseInt(trainId), trainName, stations));
        }
        return "redirect:/admin/train";
    }

    @GetMapping(value = "/admin/train", params = "edit")
    public String edit(String trainId, String trainName) {
        if (!trainId.equals("")) {
            if (!trainName.equals("")) {
                trainService.findById(Integer.parseInt(trainId)).setName(trainName);
            }
            return "redirect:/admin/train/" + trainId;
        }
        return "redirect:/admin/train";
    }

    @GetMapping("/admin/train/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Train train = trainService.findById(Integer.parseInt(id));

        model.addAttribute("trainStations", train.getSortedStations());
        model.addAttribute("stations", stationService.findAll().values());
        model.addAttribute("id", id);
        model.addAttribute("trainName", trainService.findById(Integer.parseInt(id)));
        return "editTrain";
    }

    @GetMapping(value = "/admin/train/{id}", params = "addStation")
    public String addStation(@PathVariable String id, String timeArr, String timeDep, String stations) {
        Train train = trainService.findById(Integer.parseInt(id));
        train.addStation(stationService.findByName(stations), DataTime.stringToDataTime(timeArr), DataTime.stringToDataTime(timeDep));

        return "redirect:/admin/train/"+id;
    }

    @GetMapping(value = "/admin/train/{id}", params = "deleteStation")
    public String deleteStation(@PathVariable String id, String stations) {
        Train train = trainService.findById(Integer.parseInt(id));
        train.removeStation(stationService.findByName(stations));
        return "redirect:/admin/train/"+id;
    }

}
