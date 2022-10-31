package io04.trainschedule.services;

import io04.trainschedule.models.User;

public interface UserService {
    void save(User user);
    User findByName(String username);
    User findById(int id);
}
