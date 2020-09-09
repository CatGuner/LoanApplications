package com.danila.applications.repositories;

import com.danila.applications.entities.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends CrudRepository <Application, Long> {
    Application getByApplicationNumber(Long num);
}
