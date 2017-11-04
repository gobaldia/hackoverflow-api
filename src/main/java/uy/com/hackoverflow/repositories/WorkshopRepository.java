package uy.com.hackoverflow.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uy.com.hackoverflow.models.Workshop;

import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
public interface WorkshopRepository extends CrudRepository<Workshop, Long> {

    Workshop findFirstById(@Param("id") Long id);

    @Query("select w from Workshop w left join fetch w.enrolledUsers where w.id = :id")
    Workshop findWorkshopEnrolledUsers(@Param("id") Long id);

    @Query("select w from Workshop w left join fetch w.images where w.id = :id")
    Workshop findWorkshopAndFecthImages(@Param("id") Long id);

    @Query("select w from Workshop w left join fetch w.tags where w.id = :id")
    Workshop findWorkshopAndFecthTags(@Param("id") Long id);
}
