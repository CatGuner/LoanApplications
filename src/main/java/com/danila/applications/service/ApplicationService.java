package com.danila.applications.service;

import com.danila.applications.entities.Client;

import java.util.List;

public interface ApplicationService {
    Client getApplicationEntity(Long id);
    List getAll();
    void save(Client client);
}
