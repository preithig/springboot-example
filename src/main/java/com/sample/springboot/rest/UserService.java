package com.sample.springboot.rest;

import com.sample.springboot.model.User;
import com.sample.springboot.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PRGA on 2/24/2018.
 */

@RestController
public class UserService {

    @Autowired
    public IUserRepo userRepo;

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greetUser() {
        return "Hello User";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users() {
        userRepo.findAll();
        return "Hello User";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getUser(@PathVariable(value = "userId") String userId) {
        userRepo.findOne(userId);
        return "Get the User details for id : " + userId;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String create(@RequestBody User user) {
        userRepo.save(user);
        return "Create User";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String delete(@PathVariable(value = "userId") String userId) {
        userRepo.delete(userId);
        return "Delete User for id " + userId;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String update(@PathVariable(value = "userId") String userId, @RequestBody User user) {
        return "Update User with id " + userId;
    }

}
