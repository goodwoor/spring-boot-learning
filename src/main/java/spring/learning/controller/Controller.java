package spring.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.learning.dto.response.UserResponse;
import spring.learning.mappers.CommonMapper;
import spring.learning.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final ShopService shopService;
    private final CommonMapper mapper;

    @Autowired
    Controller(
            ShopService shopService,
            CommonMapper mapper
    )
    {
        this.shopService = shopService;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/", produces = "application/json")
    public String getHomePage()
    {
        return "Home page";
    }

    //http://localhost:8080/users/all
    @GetMapping("/users/all")
    public ResponseEntity<List<UserResponse>> getUsers()
    {
        List<UserResponse> dtoUsers = shopService
                .findAllUsers()
                .stream()
                .map(mapper::toUserResponse)
                .toList();

        return ResponseEntity.ok(dtoUsers);
    }

    //todo: хочется более строгой типизации - исправить ?
    //http://localhost:8080/users?id=1
    //http://localhost:8080/users?status=ACTIVE&firstName=Мария
    //http://localhost:8080/users?firstName=М
    @GetMapping("/users")
    public ResponseEntity<?> getUserById(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String firstName
    )
    {
        if (id != null) {
            return shopService
                    .findUserById(id)
                    .map(mapper::toUserResponse)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
        else if (status != null && firstName != null) {
            List<UserResponse> dtoUsers = shopService
                    .findUsersByStatusAndFirstName(status, firstName)
                    .stream()
                    .map(mapper::toUserResponse)
                    .toList();

            return ResponseEntity.ok(dtoUsers);
        }
        else if (status == null && firstName != null) {
            List<UserResponse> dtoUsers = shopService
                    .findUsersByFirstNameCharacter(firstName)
                    .stream()
                    .map(mapper::toUserResponse)
                    .toList();

            return ResponseEntity.ok(dtoUsers);
        }

        return ResponseEntity.notFound().build();
    }
}
