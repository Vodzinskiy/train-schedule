package io04.trainschedule.repositories.implementation;

import io04.trainschedule.models.User;
import io04.trainschedule.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> repository;

    public UserRepositoryImpl() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(User user) {
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
