package uy.com.hackoverflow.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.com.hackoverflow.dtos.UserLoginInfo;
import uy.com.hackoverflow.models.User;
import uy.com.hackoverflow.repositories.UserRepository;
import uy.com.hackoverflow.models.Error;

import javax.validation.Valid;

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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    @RequestMapping(value = "/crlogin",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<?> loginUserByCR(@Valid @RequestBody UserLoginInfo body) {
        logger.info("New Request ==>" + body.toString());

        if(body.getNick() == null || body.getNick().equals("")){
            return new ResponseEntity<Error>(new Error(1, "Usaurio y/o password invalidos"), HttpStatus.OK);
        }
        User user = userRepository.findFirstByNickname(body.getNick());

        if(user == null || !user.getPwd().equals(body.getPwd())){
            return new ResponseEntity<Error>(new Error(1, "Usaurio y/o password invalidos"), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
