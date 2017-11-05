package uy.com.hackoverflow.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.com.hackoverflow.dtos.*;
import uy.com.hackoverflow.models.*;
import uy.com.hackoverflow.models.Error;
import uy.com.hackoverflow.repositories.LocationRepository;
import uy.com.hackoverflow.repositories.PlaceRepository;
import uy.com.hackoverflow.repositories.UserRepository;
import uy.com.hackoverflow.repositories.WorkshopRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserServiceController implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkshopRepository workshopRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    PlaceRepository placeRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    @RequestMapping(value = "/crlogin",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<?> loginUserByCR(@Valid @RequestBody UserLoginInfo body) {
        logger.info("New Request ==>" + body.toString());

        if(body.getNick() == null || body.getNick().equals("")){
            return new ResponseEntity<Error>(new Error(1, "Usaurio y/o password invalidos"), HttpStatus.FORBIDDEN);
        }
        User user = userRepository.findFirstByNickname(body.getNick());

        if(user == null || !user.getPwd().equals(body.getPwd())){
            return new ResponseEntity<Error>(new Error(1, "Usaurio y/o password invalidos"), HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(UserBasic.fromUser(user), HttpStatus.OK);

    }

    @Override
    @RequestMapping(value = "/{userId}/workshop",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<?> registerWorkshop(@PathVariable("userId") Long userId,
            @Valid @RequestBody RegisterWorkshop body) {
        logger.info("New Request ==>" + body.toString());

        User user = userRepository.findFirstById(userId);
        if(user == null ){
            return new ResponseEntity<Error>(new Error(1, "El usuario no existe"), HttpStatus.NOT_FOUND);
        }

        // Creo la location
        Location l = new Location();
        LocationToShow linfo = body.getPlace().getLocation();
        l.setState(linfo.getState());
        l.setCity(linfo.getCity());
        l.setAddressLine(linfo.getAddressLine());
        l.setLongitude(linfo.getLongitude());
        l.setLatitude(linfo.getLatitude());
        locationRepository.save(l);

        // Creo el Place
        Place p = new Place();
        PlaceToShow pinfo = body.getPlace();
        p.setLocation(l);
        p.setPrice(pinfo.getPrice());
        p.setCapacity(pinfo.getCapacity());
        p.setDescription(pinfo.getDescription());
        p.setName(pinfo.getName());
        placeRepository.save(p);

        Workshop w = new Workshop();
        w.setName(body.getName());
        w.setDescription(body.getName());
        w.setDate(body.getDate());
        w.setFree(body.getFree());
        w.setPrice(body.getPrice());
        w.setPlace(p);
        List<Tag> tags = new ArrayList<>();
        w.setTags(tags);
        List<Image> images = new ArrayList<>();
        w.setImages(images);
        w.setTeacher(user);
        w.setRequester(user);
        workshopRepository.save(w);

        w = workshopRepository.findWorkshopEnrolledUsers(w.getId());

        return new ResponseEntity<>(WorkshopToShowDto.fromWorkshop(w), HttpStatus.OK);
    }
}
