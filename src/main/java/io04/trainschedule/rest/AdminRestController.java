package io04.trainschedule.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io04.trainschedule.models.User;
import io04.trainschedule.repositories.UserRepository;
import io04.trainschedule.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
@OpenAPIDefinition(
        info = @Info(
                title = "Practising of REST API",
                description = "Demonstration of out knowledge of REST API with users, realizing GET, POST, PUT, DELETE operations",
                version = "v 1.0.0"

        )
)
@Tag(
        name = "User",
        description = "Operations with user, using http methods"
)
@RestController
@RequestMapping("/users")
public class AdminRestController {
    private final UserRepository userRepository;

    public AdminRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Operation(summary = "Get all users", description = "Getting all users we have, we use GET request for it, and dont take any parameters, " +
            "this operation can return only 200 status")
    @ApiResponse(responseCode = "200", description = "everything is OK and no other way))")
    @GetMapping()
    public Collection<User> getAllUser(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "3") Integer size,
                                       @RequestParam(defaultValue = "") String emailType) {
        return userRepository.findAll(page, size, emailType);
    }

    @Operation(summary = "Get user by id", description = "Getting user by his id, we use GET request for it, and take user id as parameter")
    @ApiResponse(responseCode = "200", description = "Everything is OK")
    @ApiResponse(responseCode = "404", description = "Error user with that id is not found", content = @Content)
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @Operation(summary = "Create user", description = "Creating user using json in request body, we are doing it by POST method")
    @ApiResponse(responseCode = "201", description = "Everything ok, user is created")
    @ApiResponse(responseCode = "404", description = "Error, bad request", content = @Content)
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User newUser = userRepository.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{userId}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @Operation(summary = "Update user", description = "Updating user using json in request body, we are doing it by PUT method")
    @ApiResponse(responseCode = "204", description = "Everything is ok, user updated with no returning content")
    @ApiResponse(responseCode = "404", description = "Error, bad request", content = @Content)
    @PutMapping("/{userId}")
    public  ResponseEntity<User> edit(@PathVariable Integer userId, @RequestBody User user) {
        if (userId == null || !userId.equals(user.getId())) {
            return ResponseEntity.badRequest().build();
        } else {
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
    }

    @Operation(summary = "Delete user", description = "Deleting user by id retrieved from request parameter, we are doing it by PUT method")
    @ApiResponse(responseCode = "200", description = "Everything is ok, user us deleted")
    @ApiResponse(responseCode = "404", description = "Error, user with this id is not found", content = @Content)
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
