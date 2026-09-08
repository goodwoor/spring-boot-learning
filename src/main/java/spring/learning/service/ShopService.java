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

    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id)
    {
        return userRepository.findById(id);
    }

    public List<User> findUsersByStatusAndFirstName(String status, String firstName)
    {
        return userRepository.findByStatusAndFirstName(status, firstName);
    }

    public List<User> findUsersByFirstNameCharacter(String firstNameCharacter)
    {
        return userRepository.findByFirstNameCharacter(firstNameCharacter);
    }
}
