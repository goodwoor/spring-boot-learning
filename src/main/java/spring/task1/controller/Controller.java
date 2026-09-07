package spring.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.task1.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {

    private final UserService userService;

    @Autowired
    Controller(
            UserService userService
    )
    {
        this.userService = userService;
    }

    @RequestMapping(value = "/", produces = "application/json")
    public String getHomePage()
    {
        return "Home page";
    }

    @RequestMapping("/users/all")
    public Map<String, List<String>> getUsers()
    {
        return userService.getAllUsers();
    }

    @RequestMapping("/users")
    public ResponseEntity<?> getUserById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String gender
    )
    {
        if (id != null) {
            return ResponseEntity.ok(userService.getUserById(id));
        } else if (gender != null) {
            return ResponseEntity.ok(userService.getUserByGender(gender));
        }

        return ResponseEntity.notFound().build();
    }
}
