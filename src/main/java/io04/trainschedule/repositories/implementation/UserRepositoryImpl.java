package io04.trainschedule.repositories.implementation;

import io04.trainschedule.models.User;
import io04.trainschedule.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> repository;

    public UserRepositoryImpl() {
        repository = new TreeMap<>();
        repository.put(1, new User(1, "Roma", "roma@gmail.com"));
        repository.put(2, new User(2, "Dima", "dima@gmail.com"));
        repository.put(3, new User(3, "Arsen", "arsen@NEgmail.com"));
        repository.put(4, new User(4, "Vlad", "roma@tempmail.com"));
    }

    @Override
    public User save(User user) {
        repository.put(user.getId(), user);
    }

    @Override
    public User findById(int id) {
        return repository.get(id);
    }

    @Override
    public User findByName(String name) {
        Collection<User> users = repository.values();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name))
                return user;
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Collection<User> users = repository.values();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email))
                return user;
        }
        return null;
    }
}
