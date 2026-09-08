package spring.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.learning.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByStatusAndFirstName(String status, String firstName);

    @Query("SELECT user FROM User user WHERE user.firstName LIKE CONCAT('%', :firstNameCharacter, '%')")
    public List<User> findByFirstNameCharacter(@Param("firstNameCharacter") String firstNameCharacter);
    //public List<User> findByFirstNameContainingIgnoreCase(String firstNameCharacter);
}
