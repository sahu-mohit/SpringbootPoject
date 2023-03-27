package demo.Repository;

import demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {
}
