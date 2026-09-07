package spring.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//привет
@RestController
@RequestMapping("/")
public class Controller {

    private final Service service;

    @Autowired
    Controller(
            Service service
    )
    {
        this.service = service;
    }

    @RequestMapping(value = "/", produces = "application/json")
    public String getHomePage()
    {
        return "Home page";
    }

    @RequestMapping("/users/all")
    public Map<String, List<String>> getUsers()
    {
        return service.getAllUsers();
    }

    @RequestMapping("/users")
    public ResponseEntity<?> getUserById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String gender
    )
    {
        if (id != null) {
            return ResponseEntity.ok(service.getUserById(id));
        } else if (gender != null) {
            return ResponseEntity.ok(service.getUserByGender(gender));
        }

        return ResponseEntity.notFound().build();
    }
}
