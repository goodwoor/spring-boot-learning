package spring.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.task1.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    private static final Map<String, List<String>> allUsers = Map.of(
            "male", List.of("1", "2", "3"),
            "female", List.of("4", "5", "6")
    );

    @Autowired
    UserService(
            UserRepository userRepository
    )
    {
        this.userRepository = userRepository;
    }

    public Map<String, List<String>> getAllUsers()
    {
        return allUsers;
    }

    public String getUserById(String id)
    {
        return userRepository.findUserById(allUsers, id);
    }

    public List<String> getUserByGender(String gender)
    {
        return userRepository.getUsersByGender(allUsers, gender);
    }
}
