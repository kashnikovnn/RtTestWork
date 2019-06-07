package ru.rt.testwork.controllers;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.rt.testwork.services.ReloadService;
import ru.rt.testwork.services.ReloadServiceImpl;

@RestController
@Data
public class ReloadController {

    final Logger logger = LoggerFactory.getLogger(ReloadController.class);

    @Autowired
    @Qualifier("reloadServiceImpl")
    ReloadService reloadService;

    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void reload() throws Exception {
        logger.info("Incoming POST request to reload countries...");

            reloadService.reload();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        logger.error("Error while running reload POST request. ", ex);
        ResponseEntity<String> responseEntity = new ResponseEntity("Internal server error: " + ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;

    }
}
