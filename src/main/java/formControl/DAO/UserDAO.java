package formControl.DAO;

import formControl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    @Query(value = "select * from user where id = :id", nativeQuery = true)
    User userDetail(@Param("id") long id);
    List<User> findBySex(boolean sex);

}
