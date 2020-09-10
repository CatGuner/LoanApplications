package com.danila.applications;

import com.danila.applications.data.EntityData;
import com.danila.applications.repositories.ApplicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TestRepository {

    @Autowired
    private ApplicationRepository repository;

    @Test
    public void testPostAndGet() {
        repository.save(EntityData.createApplicationEntity());
        Assertions.assertNotNull(repository.findByApplicationNumber(3L));
    }
}
