package io04.trainschedule;

import io04.trainschedule.models.User;
import io04.trainschedule.repositories.implementation.UserRepositoryImpl;
import io04.trainschedule.services.implementation.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

        UserRepositoryImpl ur = new UserRepositoryImpl();
        new UserServiceImpl(ur).save(new User(1,"2312","1","1"));
        System.out.println(new UserServiceImpl(ur).findById(1).getName());
    }
}
