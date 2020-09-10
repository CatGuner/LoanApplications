package com.danila.applications.mappers;

import com.danila.applications.data.EntityData;
import com.danila.applications.data.InputData;
import com.danila.applications.entities.Application;
import com.danila.applications.entities.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMappingToEntity {

    @SneakyThrows
    @Test
    @DisplayName("Testing mappint to Entity")
    public void testMappingToEntity() {

        Application testingApplication = ApplicationMapper.INSTANCE.toApplicationEntity(InputData.createLoanApplication());
        Application applicationEntity = EntityData.createApplicationEntity();

        //Application testing
        Assertions.assertEquals(testingApplication.getAmount(), applicationEntity.getAmount());
        Assertions.assertEquals(testingApplication.getApplicationNumber(), applicationEntity.getApplicationNumber());
        Assertions.assertEquals(testingApplication.getCurrency(), applicationEntity.getCurrency());

        //Applicant testing
        clientsTesting(testingApplication.getApplicant(), applicationEntity.getApplicant());

        //Guarantor testing
        clientsTesting(testingApplication.getGuarantor(), applicationEntity.getGuarantor());
    }

    private void clientsTesting(Client client, Client application) throws JsonProcessingException {
        Assertions.assertEquals(client.getFirstName(), application.getFirstName());
        Assertions.assertEquals(client.getLastName(), application.getLastName());
        Assertions.assertEquals(client.getPassportSeries(), application.getPassportSeries());
        Assertions.assertEquals(client.getPassportNumber(), application.getPassportNumber());

        //Phones testing
        Assertions.assertEquals(client.getPhones(), application.getPhones());
    }
}
