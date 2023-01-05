package io04.trainschedule.repositories.implementation;

import io04.trainschedule.models.User;
import io04.trainschedule.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class UserRepositoryImpl implements UserRepository {
    TreeMap<Integer, User> repository;

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
        return user;
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

//    @Override
//    public User findByEmail(String email) {
//        Collection<User> users = repository.values();
//        for (User user : users) {
//            if (user.getEmail().equalsIgnoreCase(email))
//                return user;
//        }
//        return null;
//    }

    @Override
    public ArrayList<User> findAll(int page, int size, String emailType) {
        ArrayList<ArrayList<User>> pageOfUsers = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        if (Objects.equals(emailType, "")) {
            users = new ArrayList<>(repository.values());
        } else {
            Pattern pattern = Pattern.compile("(?<=@)[^.]+(?=\\.)");
            for (User u: repository.values()) {
                Matcher matcher = pattern.matcher(u.getEmail());
                if (matcher.find()) {
                    if (matcher.group().equals(emailType)) {
                        users.add(u);
                    }
                }
            }
            if (users.isEmpty()) {
                return users;
            }
        }
        int count = 0;
        for (int i = 0; i < page; i++) {
            ArrayList<User> slice = new ArrayList<>();
            for (int j = count; j < count + size; j++) {
                slice.add(users.get(j));
                if (j == users.size() - 1) {
                    break;
                }
            }
            count += size;
            pageOfUsers.add(slice);
        }
        return pageOfUsers.get(page - 1);
    }

    @Override
    public User removeById(int id){
        return repository.remove(id);
    }
}
