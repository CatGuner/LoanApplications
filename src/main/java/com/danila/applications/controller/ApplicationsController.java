package com.danila.applications.controller;

import com.danila.applications.entities.Client;
import com.danila.applications.mappers.ApplicationMapper;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApplicationsController {

    private ApplicationService applicationService;


    @PostMapping(path = "/create")
    public void postApplication(@RequestBody LoanApplication application){
        applicationService.save(ApplicationMapper.INSTANCE.toApplicationEntity(application));
    }

    @GetMapping(path = "/client/{number}")
    public Client getApplication(@PathVariable Long number){
//        return applicationService.getApplicationEntity(number);
        return null;
    }

    @GetMapping(path = "/client/all")
    public List getApplication(){
        return applicationService.getAll();
    }
}
