package uy.com.hackoverflow.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uy.com.hackoverflow.models.User;

/**
 * Created by emiliano on  04/11/17.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    User findFirstByNickname(String registration);

    @Query("select u from User u left join fetch u.enrolledWorkshops where u.id = :id")
    User findUserAndFetchEnrolledWorkshops(@Param("id") Long id);

    User findFirstById(@Param("id") Long id);

}
