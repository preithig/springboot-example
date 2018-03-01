package com.sample.springboot.rest;

import com.google.common.collect.Lists;
import com.sample.springboot.model.User;
import com.sample.springboot.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<User> users() {
        return Lists.newArrayList(userRepo.findAll());
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable(value = "userId") String userId) {
        return userRepo.findOne(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "userId") String userId) {
        userRepo.delete(userId);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public User update(@PathVariable(value = "userId") String userId, @RequestBody User user) {
        User user1 = userRepo.findOne(userId);
        if (user1 != null) {
            return userRepo.save(user);
        }
        return null;
    }

}
