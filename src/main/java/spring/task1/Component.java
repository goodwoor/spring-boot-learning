package spring.task1;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Component
public class Component {

    public String findUserById(Map<String, List<String>> users, String id)
    {
        return users.values().stream()
                .flatMap(List::stream)
                .filter(userId -> userId.equals(id))
                .findFirst()
                .orElse("not found: " + id);
    }

    public List<String> getUsersByGender(Map<String, List<String>> users, String gender)
    {
        List<String> genderUsers = users.get(gender);

        return genderUsers == null
                ? List.of("not found gender: " + gender)
                : genderUsers;
    }
}
