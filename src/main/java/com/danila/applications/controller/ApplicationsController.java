package com.danila.applications.controller;

import com.danila.applications.entities.Client;
import com.danila.applications.mappers.ClientMapper;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApplicationsController {

    private final ApplicationService applicationService;

    private final ClientMapper mapper;



    @PostMapping(path = "/create")
    public Client postApplication(@RequestBody LoanApplication application){
        return mapper.toClientEntity(application);
    }

    @GetMapping(path = "/client/{number}")
    public Client getApplication(@PathVariable Long number){
        return applicationService.getApplicationEntity(number);
    }

    @GetMapping(path = "/client/all")
    public List getApplication(){
        return applicationService.getAll();
    }
}


/* Description:

Parameter 1 of constructor in com.danila.applications.controller.ApplicationsController required a bean of type 'com.danila.applications.mappers.ClientMapper' that could not be found.


Action:

Consider defining a bean of type 'com.danila.applications.mappers.ClientMapper' in your configuration.*/