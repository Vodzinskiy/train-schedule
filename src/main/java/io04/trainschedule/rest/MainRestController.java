package io04.trainschedule.rest;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Train;
import io04.trainschedule.repositories.TrainRepository;
import io04.trainschedule.services.StationService;
import io04.trainschedule.services.TrainFinderService;
import io04.trainschedule.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trains_rest")
public class MainRestController {

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TrainFinderService trainFinderService;

    @Autowired
    StationService stationService;

    @GetMapping
    public ResponseEntity<?> getTrains(@RequestParam String stationOfDeparture, @RequestParam String stationOfArrival, @RequestParam String dateTime){
        if (stationOfDeparture == null || stationOfArrival == null || dateTime == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(trainFinderService.getSuitableTrain(stationService.findByName(stationOfDeparture), stationService.findByName(stationOfArrival), DataTime.stringToDataTime(dateTime)));
    }
}
