package uy.com.hackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uy.com.hackoverflow.models.User;
import uy.com.hackoverflow.models.Workshop;

import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
//    List<Workshop> findByNickname(String registration);

     Workshop findFirstById(@Param("id") Long id);

}
