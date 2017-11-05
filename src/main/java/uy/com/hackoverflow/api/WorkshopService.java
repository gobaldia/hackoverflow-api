package uy.com.hackoverflow.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uy.com.hackoverflow.dtos.EnrollInWorkshop;
import uy.com.hackoverflow.dtos.UserLoginInfo;

import javax.validation.Valid;

/**
 * Created by emiliano on  04/11/17.
 */

public interface WorkshopService {
    @RequestMapping(value = "/workshops",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<?> listAllWorkshops();

    @RequestMapping(value = "/workshops/{workshopId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<?> findWorkshopsById(@PathVariable("workshopId") Long workshopId);

    @RequestMapping(value = "/workshops/{workshopId}/enroll",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<?> enrollInWorkshop(@PathVariable("workshopId") Long workshopId,
                                       @Valid @RequestBody EnrollInWorkshop body);
}
