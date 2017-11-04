package uy.com.hackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uy.com.hackoverflow.models.Location;
import uy.com.hackoverflow.models.User;

/**
 * Created by emiliano on  04/11/17.
 */
public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findFirstById(@Param("id") Long id);
}
