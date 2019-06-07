package ru.rt.testwork.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

            reloadService.reload();
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex) {
        logger.error("Error while POST request. ", ex);
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error",ex);
    }
}
