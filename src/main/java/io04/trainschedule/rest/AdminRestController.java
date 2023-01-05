package io04.trainschedule.rest;

import io04.trainschedule.models.User;
import io04.trainschedule.repositories.UserRepository;
import io04.trainschedule.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class AdminRestController {
    private final UserRepository userRepository;

    public AdminRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public Collection<User> getAllUser(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "3") Integer size,
                                       @RequestParam(defaultValue = "") String emailType) {
        return userRepository.findAll(page, size, emailType);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{userId}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{userId}")
    public  ResponseEntity<User> edit(@PathVariable Integer userId, @RequestBody User user) {
        if (userId == null || !userId.equals(user.getId())) {
            return ResponseEntity.badRequest().build();
        } else {
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable int userId) {
        User user = userRepository.removeById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

}
