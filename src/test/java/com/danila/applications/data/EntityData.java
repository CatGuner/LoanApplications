package com.danila.applications.data;

import com.danila.applications.entities.Application;
import com.danila.applications.entities.Client;
import com.danila.applications.entities.Phone;

public class EntityData {

    public static Application createApplicationEntity() {
        Application application = new Application();
        application.setAmount(2L);
        application.setApplicationNumber(3L);
        application.setCurrency("RUBLES");

        application.setApplicant(new Client());
        application.getApplicant().setFirstName("TestApplicantFirstName");
        application.getApplicant().setLastName("TestApplicantLastName");
        application.getApplicant().setPassportSeries(4910);
        application.getApplicant().setPassportNumber(386273);

        Phone applicantHomePhone = new Phone();
        applicantHomePhone.setPhoneNumber(2349610L);
        applicantHomePhone.setType("HOME");
        application.getApplicant().addPhone(applicantHomePhone);

        Phone applicantMobilePhone = new Phone();
        applicantMobilePhone.setPhoneNumber(79096841230L);
        applicantMobilePhone.setType("MOBILE");
        application.getApplicant().addPhone(applicantMobilePhone);

        application.setGuarantor(new Client());
        application.getGuarantor().setFirstName("TestGuarantorFirstName");
        application.getGuarantor().setLastName("TestGuarantorLastName");
        application.getGuarantor().setPassportSeries(4911);
        application.getGuarantor().setPassportNumber(756834);


        Phone gHomePhone = new Phone();
        gHomePhone.setPhoneNumber(2341298L);
        gHomePhone.setType("HOME");
        application.getGuarantor().addPhone(gHomePhone);

        Phone gMobilePhone = new Phone();
        gMobilePhone.setPhoneNumber(79034568822L);
        gMobilePhone.setType("MOBILE");
        application.getGuarantor().addPhone(gMobilePhone);

        return application;
    }
}
