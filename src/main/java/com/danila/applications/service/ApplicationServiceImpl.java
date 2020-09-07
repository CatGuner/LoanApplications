package com.danila.applications.service;

import com.danila.applications.entities.Client;
import com.danila.applications.repositories.ApplicationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository client;


    @Override
    public Client getApplicationEntity(Long id) {
        return client.getById(id);
    }

    @Override
    public List getAll() {
        return (List) client.findAll();
    }

    @Override
    public void save(Client client) {
        this.client.save(client);
    }
}
