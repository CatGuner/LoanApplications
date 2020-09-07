package com.danila.applications.repositories;

import com.danila.applications.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends CrudRepository <Client, Long> {
    Client getById(Long num);
}
