package com.danila.applications.service;

import com.danila.applications.entities.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationService {

    Application getApplicationEntity(Long number);
    List getAll();
    void save(Application application);
}
