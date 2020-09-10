package com.danila.applications.service;

import com.danila.applications.entities.Application;
import com.danila.applications.model.LoanApplication;

import java.util.List;

public interface ApplicationService {

    Application getApplicationEntity(Long number);

    List getAll();

    void save(LoanApplication application);
}
