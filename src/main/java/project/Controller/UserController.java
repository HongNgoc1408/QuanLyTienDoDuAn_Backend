package project.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.Entity.User;
import project.Repo.UserRepo;
import project.Service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.listAll();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            user.set_id(id); // Ensure the ID remains the same
            userService.saveOrUpdate(user);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/count")
    public ResponseEntity<Long> getUserCount() {
        long count = mongoTemplate.count(new Query(), User.class, "User");
        return ResponseEntity.ok(count);
    }

    @PostMapping("/check/username")
    public ResponseEntity<Boolean> checkUsernameExistence(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        boolean isExisting = userService.checkUsernameExistence(username);
        return ResponseEntity.ok(isExisting);
    }

    @PostMapping("/check/email")
    public ResponseEntity<Boolean> checkEmailExistence(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        boolean isExisting = userService.checkEmailExistence(email);
        return ResponseEntity.ok(isExisting);
    }

    @PostMapping("/check/id")
    public ResponseEntity<Boolean> checkUserIdExistence(@RequestBody Map<String, String> request) {
        String userId = request.get("id_user");
        boolean isExisting = userService.checkUserIdExistence(userId);
        return ResponseEntity.ok(isExisting);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            if (foundUser.getIsAdmin()) {
                return ResponseEntity.ok("admin");
            } else {
                return ResponseEntity.ok("employee");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
