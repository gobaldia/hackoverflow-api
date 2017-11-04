package uy.com.hackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import uy.com.hackoverflow.models.Tag;

/**
 * Created by emiliano on  04/11/17.
 */
public interface TagRepository extends CrudRepository<Tag, Long> {
}
