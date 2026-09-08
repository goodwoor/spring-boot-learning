package spring.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.entity.User;
import spring.learning.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final UserRepository userRepository;

    @Autowired
    ShopService(
            UserRepository userRepository
    )
    {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findUserById(id);
    }
}
