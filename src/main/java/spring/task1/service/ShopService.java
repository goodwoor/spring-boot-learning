package spring.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.task1.entity.User;
import spring.task1.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class ShopService {

    private final UserRepository userRepository;

    private static final Map<String, List<String>> allUsers = Map.of(
            "male", List.of("1", "2", "3"),
            "female", List.of("4", "5", "6")
    );

    @Autowired
    ShopService(
            UserRepository userRepository
    )
    {
        this.userRepository = userRepository;
    }

    public Map<String, List<String>> getAllUsers()
    {
        return allUsers;
    }

    public User getUserById(Long id)
    {
        return userRepository.findUserById(id);
    }
}
