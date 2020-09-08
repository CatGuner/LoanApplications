package com.danila.applications.service;

import com.danila.applications.entities.Application;
import com.danila.applications.entities.Client;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationService {

    Application getApplicationEntity(Integer id);
    List getAll();
    void save(Application application);
}
