package io04.trainschedule;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;
import io04.trainschedule.repositories.StationRepository;
import io04.trainschedule.repositories.TrainRepository;
import io04.trainschedule.repositories.implementation.StationRepositoryImpl;
import io04.trainschedule.repositories.implementation.TrainRepositoryImpl;
import io04.trainschedule.services.StationService;
import io04.trainschedule.services.TrainService;
import io04.trainschedule.services.implementation.StationServiceImpl;
import io04.trainschedule.services.implementation.TrainFinderServiceImpl;
import io04.trainschedule.services.implementation.TrainServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);


        /*StationRepository stationRepository = new StationRepositoryImpl();

        Station kiev = new Station(0,"Київ");
        Station vin = new Station(1,"Вінниця");
        Station odesa = new Station(2,"Одеса");

        stationRepository.save(kiev);
        stationRepository.save(vin);
        stationRepository.save(odesa);

        TrainRepository trainRepository = new TrainRepositoryImpl();
        HashMap<Station, ArrayList<DataTime>> train1 = new HashMap<>();
        train1.put(kiev, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,0),new DataTime(15,10,"Sut",19,0))));
        train1.put(vin, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,30),new DataTime(15,10,"Sut",20,40))));
        train1.put(odesa, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",21,0),new DataTime(15,10,"Sut",21,0))));
        Train train11 = new Train(0,"Київ-Одеса",train1);
        trainRepository.save(train11);

        HashMap<Station, ArrayList<DataTime>> train2 = new HashMap<>();
        train2.put(vin, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,30),new DataTime(15,10,"Sut",20,0))));
        train2.put(odesa, new ArrayList<>(Arrays.asList(new DataTime(21,30,"Sut",21,0),new DataTime(15,10,"Sut",21,30))));
        Train train22 = new Train(1,"Вінниця-Одеса",train2);
        trainRepository.save(train22);
//
//        kiev.setTrains(new ArrayList<>(List.of(train11)));
//        vin.setTrains(new ArrayList<>(List.of(train11, train22)));
//        odesa.setTrains(new ArrayList<>(List.of(train11, train22)));

        TrainFinderServiceImpl tr = new TrainFinderServiceImpl();

        System.out.println(Arrays.toString(tr.getSuitableTrain(vin,odesa).toArray()));*/
        StationRepository stationRepository = new StationRepositoryImpl();
        Station kiev = new Station(0,"Київ");
        Station vin = new Station(1,"Вінниця");
        Station odesa = new Station(2,"Одеса");
        stationRepository.save(kiev);
        stationRepository.save(vin);
        stationRepository.save(odesa);

        TrainRepository trainRepository = new TrainRepositoryImpl();
        HashMap<Station, ArrayList<DataTime>> train1 = new HashMap<>();
        train1.put(kiev, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,0),new DataTime(15,10,"Sut",19,0))));
        train1.put(vin, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,30),new DataTime(15,10,"Sut",20,40))));
        train1.put(odesa, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",21,0),new DataTime(15,10,"Sut",21,0))));
        Train train11 = new Train(0,"Київ-Одеса",train1);
        trainRepository.save(train11);

//        TrainService trainService = new TrainServiceImpl(trainRepository);
//        HashMap<Station, ArrayList<DataTime>> train2 = new HashMap<>();
/*        train2.put(kiev, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,0),new DataTime(15,10,"Sut",19,0))));
        train2.put(vin, new ArrayList<>(Arrays.asList(new DataTime(15,10,"Sut",19,30),new DataTime(15,10,"Sut",20,40))));
//        System.out.println(train11);
//        System.out.println(odesa.getTrains().toString());
        System.out.println(odesa.getTrains().toString());
        trainService.editTrain(0, "Kyiv-Vinnytsya", train2);
        System.out.println(odesa.getTrains().toString());
        trainService.delete(0);
        System.out.println(vin.getTrains().toString());*/
        StationService stationService = new StationServiceImpl(stationRepository);
        System.out.println(train11.getArrivalStations().toString());
        stationService.editName(1, "Луцьк");
        System.out.println(train11.getArrivalStations().toString());
        try{
            System.out.println(stationRepository.findById(1).getName());
        }catch (Exception e){
            System.out.println("No station");
        }
    }
}
