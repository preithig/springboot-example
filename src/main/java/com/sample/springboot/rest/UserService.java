package com.sample.springboot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PRGA on 2/24/2018.
 */

@RestController
public class UserService {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greetUser(){
        return "Hello User";
    }

}
