package com.danila.applications.controller;

import com.danila.applications.mappers.ApplicationMapper;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationsController {

    @Autowired
    private ApplicationService applicationService;


    @PostMapping(path = "/create")
    public void postApplication(@RequestBody LoanApplication application){
        applicationService.save(ApplicationMapper.INSTANCE.toApplicationEntity(application));
    }

    @GetMapping(path = "/application/{number}")
    public LoanApplication getApplication(@PathVariable Long number){
        return ApplicationMapper.INSTANCE.fromApplicationEntity(
                applicationService.getApplicationEntity(number)
        );
    }

    @GetMapping(path = "/application/all")
    public List getApplication(){
        return applicationService.getAll();
    }
}
