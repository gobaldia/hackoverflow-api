package uy.com.hackoverflow.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.com.hackoverflow.models.Error;
import uy.com.hackoverflow.models.Workshop;
import uy.com.hackoverflow.repositories.WorkshopRepository;

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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    @RequestMapping(value = "/workshops",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> listAllWorkshops() {
        logger.info("New Request ==> findALlWorkshops");
        List<Workshop> workshops = new ArrayList<>();
        for(Workshop w : workshopRepository.findAll()){
            workshops.add(w);
        }
        return new ResponseEntity<List<Workshop>>(workshops, HttpStatus.OK);
    }

    @RequestMapping(value = "/workshops/{workshopId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<?> findWorkshopsById(@PathVariable("workshopId") Long workshopId) {
        logger.info("New Request ==>" + workshopId);

        if(workshopId == null){
            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
        }

        Workshop workshop = workshopRepository.findFirstById(workshopId);
        if(workshop == null){
            return new ResponseEntity<Error>(new Error(404, "Workshop no encontrado"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(workshop, HttpStatus.OK);
    }
}
