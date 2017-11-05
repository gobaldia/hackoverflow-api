package uy.com.hackoverflow.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.com.hackoverflow.dtos.EnrollInWorkshop;
import uy.com.hackoverflow.dtos.WorkshopToShowDto;
import uy.com.hackoverflow.models.Error;
import uy.com.hackoverflow.models.User;
import uy.com.hackoverflow.models.Workshop;
import uy.com.hackoverflow.repositories.UserRepository;
import uy.com.hackoverflow.repositories.WorkshopRepository;
import uy.com.hackoverflow.utils.ListUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
@CrossOrigin
@RestController
public class WorkshopServiceController implements WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    @RequestMapping(value = "/workshops",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> listAllWorkshops() {
        logger.info("New Request ==> findALlWorkshops");
        List<WorkshopToShowDto> workshops = new ArrayList<>();
        for (Workshop w : workshopRepository.findAll()) {
            workshops.add(WorkshopToShowDto.fromWorkshop(w));
        }
        return new ResponseEntity<List<WorkshopToShowDto>>(workshops, HttpStatus.OK);
    }

    @RequestMapping(value = "/workshops/{workshopId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<?> findWorkshopsById(@PathVariable("workshopId") Long workshopId) {
        logger.info("New Request ==>" + workshopId);

        if (workshopId == null) {
            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
        }

//        Workshop workshop = workshopRepository.findWorkshopEnrolledUsers(workshopId);
        Workshop workshop = workshopRepository.findFirstById(workshopId);
        if (workshop == null) {
            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
        }

        WorkshopToShowDto result = WorkshopToShowDto.fromWorkshop(workshop);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/workshops/{workshopId}/enroll",
            produces = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<?> enrollInWorkshop(@PathVariable("workshopId") Long workshopId,
                                              @Valid @RequestBody EnrollInWorkshop body) {
        logger.info("New Request ==>" + workshopId);

        if (workshopId == null) {
            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
        }

        Workshop workshop = workshopRepository.findFirstById(workshopId);
        if (workshop == null) {
            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
        }

        if (body.getUserId() == null) {
            return new ResponseEntity<Error>(new Error(404, "Usuario no encontrado"), HttpStatus.NOT_FOUND);
        }

        User user = userRepository.findUserAndFetchEnrolledWorkshops(body.getUserId());
        if (user == null) {
            return new ResponseEntity<Error>(new Error(404, "Usuario no encontrado"), HttpStatus.NOT_FOUND);
        }

        if (ListUtils.userEnrollmentInWorkshop(user.getEnrolledWorkshops(), workshopId)) {
            return new ResponseEntity<Error>(new Error(409, "El usuario ya esta inscripto al taller"), HttpStatus.CONFLICT);
        }
        user.enrollInWorkshop(workshop);
        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/workshops/{workshopId}/old",
//            produces = {"application/json"},
//            method = RequestMethod.GET)
//    public ResponseEntity<?> findWorkshopsById2(@PathVariable("workshopId") Long workshopId) {
//        logger.info("New Request ==>" + workshopId);
//
//        if(workshopId == null){
//            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
//        }
//
//        Workshop workshop = workshopRepository.findFirstById(workshopId);
//
//        if(workshop == null){
//            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(workshop, HttpStatus.OK);
//    }
}
