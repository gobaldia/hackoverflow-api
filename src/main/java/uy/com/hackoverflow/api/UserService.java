package uy.com.hackoverflow.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uy.com.hackoverflow.dtos.UserLoginInfo;

import javax.validation.Valid;

/**
 * Created by emiliano on  04/11/17.
 */
@RequestMapping("/users")
public interface UserService {
    @RequestMapping(value = "/crlogin",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<?> loginUserByCR(@Valid @RequestBody UserLoginInfo body);
}
