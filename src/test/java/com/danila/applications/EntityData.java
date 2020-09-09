package com.danila.applications;

import com.danila.applications.entities.Application;
import com.danila.applications.entities.Client;
import com.danila.applications.entities.Phone;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EntityData {

    public static Application application;

    public EntityData(){
        application = new Application();
        application.setAmount(2L);
        application.setApplicationNumber(3L);
        application.setCurrency("RUBLES");

        application.setApplicant(new Client());
        application.getApplicant().setFirstName("TestApplicantFirstName");
        application.getApplicant().setLastName("TestApplicantLastName");
        application.getApplicant().setPassportSeries(4910);
        application.getApplicant().setPassportNumber(386273);

        Phone applicantMobilePhone = new Phone();
        applicantMobilePhone.setPhoneNumber(79096841230L);
        applicantMobilePhone.setType("MOBILE");
        applicantMobilePhone.setClient(application.getApplicant());
        application.getApplicant().addPhone(applicantMobilePhone);

        Phone applicantHomePhone = new Phone();
        applicantHomePhone.setPhoneNumber(2349610L);
        applicantHomePhone.setType("HOME");
        applicantHomePhone.setClient(application.getApplicant());
        application.getApplicant().addPhone(applicantHomePhone);

        application.setGuarantor(new Client());
        application.getGuarantor().setFirstName("TestGuarantorFirstName");
        application.getGuarantor().setLastName("TestGuarantorLastName");
        application.getGuarantor().setPassportSeries(4911);
        application.getGuarantor().setPassportNumber(756834);

        Phone gMobilePhone = new Phone();
        gMobilePhone.setPhoneNumber(79034568822L);
        gMobilePhone.setType("MOBILE");
        gMobilePhone.setClient(application.getGuarantor());
        application.getGuarantor().addPhone(applicantMobilePhone);

        Phone gHomePhone = new Phone();
        gHomePhone.setPhoneNumber(2341298L);
        gHomePhone.setType("HOME");
        gHomePhone.setClient(application.getGuarantor());
        application.getGuarantor().addPhone(applicantHomePhone);
    }
}
