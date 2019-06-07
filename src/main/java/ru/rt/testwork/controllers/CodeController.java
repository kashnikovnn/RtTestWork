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
import ru.rt.testwork.services.CodeService;

@RestController
@RequestMapping("/code")
@Data
public class CodeController {

    final Logger logger = LoggerFactory.getLogger(CodeController.class);

    @Autowired
    @Qualifier("codeServiceImpl")
    CodeService codeService;

    @RequestMapping(value = "/{countryname}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    String getCodeByCountryName(@PathVariable("countryname") String countryName){
        logger.info("Incoming GET request code by country name " + countryName+"...");

        String code = codeService.getCodeByCountryName(countryName);

        if(code == null){
            logger.info("GET request code by country " + countryName + " return ERROR 404");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone code not found");

        }
        logger.info("GET request code by country " + countryName + " return " + code);
        return code;

    }

    @ExceptionHandler(ResponseStatusException.class)
    public void handleResponseStatusException(ResponseStatusException ex) {
        throw ex;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        logger.error("Error while GET request code by country: ", ex );
        ResponseEntity<String> responseEntity = new ResponseEntity("Internal server error: " + ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;

    }
}
