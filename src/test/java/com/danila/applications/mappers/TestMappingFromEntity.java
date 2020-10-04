package com.danila.applications.mappers;

import com.danila.applications.data.EntityData;
import com.danila.applications.data.InputData;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestMappingFromEntity {

    @Test
    @DisplayName("Testing mapping from entity")
    public void testMappingFromEntity() {

        LoanApplication testingApplication = ApplicationMapper.INSTANCE.fromApplicationEntity(EntityData.createApplicationEntity());
        LoanApplication rightApplication = InputData.createLoanApplication();

        // Application info testing
        Assertions.assertEquals(testingApplication.getAmount(), rightApplication.getAmount());
        Assertions.assertEquals(testingApplication.getCurrency(), rightApplication.getCurrency());
        Assertions.assertEquals(testingApplication.getNumber(), rightApplication.getNumber());

        // Applicant testing
        personTesting(testingApplication.getApplicant(), rightApplication.getApplicant());

        // Guarantor testing
        personTesting(testingApplication.getGuarantor(), rightApplication.getGuarantor());
    }

    private void personTesting(Person testingPerson, Person rightPerson) {
        Assertions.assertEquals(testingPerson.getFirstName(), rightPerson.getFirstName());
        Assertions.assertEquals(testingPerson.getLastName(), rightPerson.getLastName());
        Assertions.assertEquals(testingPerson.getPassport(), rightPerson.getPassport());
        Assertions.assertEquals(testingPerson.getHomePhone(), rightPerson.getHomePhone());
        Assertions.assertEquals(testingPerson.getMobilePhone(), testingPerson.getMobilePhone());
    }
}
