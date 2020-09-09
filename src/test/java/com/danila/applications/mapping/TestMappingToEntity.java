package com.danila.applications.mapping;

import com.danila.applications.EntityData;
import com.danila.applications.InputData;
import com.danila.applications.entities.Application;
import com.danila.applications.entities.Client;
import com.danila.applications.mappers.ApplicationMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMappingToEntity {

    @Test
    @DisplayName("Testing mappint to Entity")
    public void testMappingToEntity(){
        //Application testing
        Application testingApplication = ApplicationMapper.INSTANCE.toApplicationEntity(InputData.application);
        Assertions.assertEquals(testingApplication.getAmount(), EntityData.application.getAmount());
        Assertions.assertEquals(testingApplication.getApplicationNumber(), EntityData.application.getApplicationNumber());
        Assertions.assertEquals(testingApplication.getCurrency(), EntityData.application.getCurrency());

        //Applicant testing
        clientsTesting(testingApplication.getApplicant(), EntityData.application.getApplicant());

        //Guarantor testing
        clientsTesting(testingApplication.getGuarantor(), EntityData.application.getGuarantor());

    }

    private void clientsTesting(Client client, Client application){
        Assertions.assertEquals(client.getFirstName(),      application.getFirstName());
        Assertions.assertEquals(client.getLastName(),       application.getLastName());
        Assertions.assertEquals(client.getPassportSeries(), application.getPassportSeries());
        Assertions.assertEquals(client.getPassportNumber(), application.getPassportNumber());

        //Phones testing
        Assertions.assertEquals(client.getPhones(), application.getPhones());
    }
}
