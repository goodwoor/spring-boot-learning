package spring.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.task1.entity.User;
import spring.task1.service.ShopService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {

    private final ShopService shopService;

    @Autowired
    Controller(
            ShopService shopService
    )
    {
        this.shopService = shopService;
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
    public User getUserById(
            @RequestParam(required = true) Long id
    )
    {
        return shopService.getUserById(id);
    }
}
