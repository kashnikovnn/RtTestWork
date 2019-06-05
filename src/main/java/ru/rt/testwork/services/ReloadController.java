package ru.rt.testwork.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReloadController {

    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void reload(){

    }

}
