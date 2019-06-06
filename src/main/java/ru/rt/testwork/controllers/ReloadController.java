package ru.rt.testwork.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.rt.testwork.services.ReloadService;

@RestController
public class ReloadController {

    final Logger logger = LoggerFactory.getLogger(ReloadController.class);

    @Autowired
    ReloadService reloadService;

    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void reload() throws Exception {
        logger.info("Incoming POST request to reload countries...");
        try {
            reloadService.reload();
        }catch (Exception e){
            logger.error("Error while POST request. " ,e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

}
