package io04.trainschedule.controllers;

import io04.trainschedule.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminTrainController {

    @Autowired
    TrainService trainService;


}
