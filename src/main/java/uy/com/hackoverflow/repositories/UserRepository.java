package uy.com.hackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import uy.com.hackoverflow.models.User;

/**
 * Created by emiliano on  04/11/17.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    User findFirstByNickname(String registration);
}
