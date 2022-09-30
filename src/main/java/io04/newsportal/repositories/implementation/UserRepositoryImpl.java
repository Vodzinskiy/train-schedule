package io04.newsportal.repositories.implementation;

import io04.newsportal.models.User;
import io04.newsportal.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Map<Integer, User> repository;

    public UserRepositoryImpl() {
        this.repository = new HashMap<>();
    }

    @Override
    public void store(User user) {
        repository.put(user.getId(), user);
    }

    @Override
    public User retrieve(int id) {
        return repository.get(id);
    }

    @Override
    public User search(String name) {
        Collection<User> users = repository.values();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name))
                return user;
        }
        return null;
    }

    @Override
    public User delete(int id) {
        User user = repository.get(id);
        this.repository.remove(id);
        return user;
    }
}
