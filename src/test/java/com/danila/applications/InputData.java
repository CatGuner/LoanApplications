package com.danila.applications;

import com.danila.applications.model.LoanApplication;
import com.danila.applications.model.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class InputData {

    public static LoanApplication application;

    public InputData(){
        application = new LoanApplication();
        application.setAmount(2L);
        application.setNumber(3L);
        application.setCurrency("RUBLES");
        application.setApplicant(new Person("TestApplicantFirstName",
                                            "TestApplicantLastName",
                                            "4910386273",
                                            "79096841230",
                                            "2349610"));
        application.setGuarantor(new Person("TestGuarantorFirstName",
                                            "TestGuarantorLastName",
                                            "4911756834",
                                            "79034568822",
                                            "2341298"));
    }
}
