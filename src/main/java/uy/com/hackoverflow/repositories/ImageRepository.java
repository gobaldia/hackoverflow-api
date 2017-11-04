package uy.com.hackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import uy.com.hackoverflow.models.Image;

/**
 * Created by emiliano on  04/11/17.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {

}
