package spring.task1;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    private final Component component;

    private static final Map<String, List<String>> allUsers = Map.of(
            "male", List.of("1", "2", "3"),
            "female", List.of("4", "5", "6")
    );

    @Autowired
    Service(
            Component component
    )
    {
        this.component = component;
    }

    public Map<String, List<String>> getAllUsers()
    {
        return allUsers;
    }

    public String getUserById(String id)
    {
        return component.findUserById(allUsers, id);
    }

    public List<String> getUserByGender(String gender)
    {
        return component.getUsersByGender(allUsers, gender);
    }
}
