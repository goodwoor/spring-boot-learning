package spring.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.entity.User;
import spring.learning.repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findUserById(id);
    }
}
