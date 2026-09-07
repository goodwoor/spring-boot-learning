package spring.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.task1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserById(Long id);
}
