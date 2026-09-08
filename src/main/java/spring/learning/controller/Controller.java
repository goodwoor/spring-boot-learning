package spring.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.learning.dto.response.UserResponse;
import spring.learning.mappers.CommonMapper;
import spring.learning.service.ShopService;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/users/all")
    public Map<String, List<String>> getUsers()
    {
        return shopService.getAllUsers();
    }

    @RequestMapping("/users")
    public ResponseEntity<UserResponse> getUserById(
            @RequestParam(required = true) Long id
    )
    {
        return shopService
                .getUserById(id)
                .map(mapper::toUserResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
