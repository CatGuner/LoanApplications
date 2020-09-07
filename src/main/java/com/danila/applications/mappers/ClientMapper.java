package com.danila.applications.mappers;


import com.danila.applications.entities.Client;
import com.danila.applications.entities.Phone;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.model.Person;
import lombok.NoArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class ClientMapper {
    private ApplicationMapper applicationMapper;
    private PhoneMapper phoneMapper;

    @Mappings({
            @Mapping(source = "Person.firstName", target = "firstName"),
            @Mapping(source = "Person.lastName", target = "lastName"),

    })
    public abstract Client toClientEntity(LoanApplication application);

    @AfterMapping
    void parsePassword(@MappingTarget Client client, Person person){
        client.setPassportSeries(Integer.parseInt(person.getPassport().substring(0,4)));
        client.setPassportNumber(Integer.parseInt(person.getPassport().substring(4)));
    }

    @AfterMapping
    void addApplicationFromPersons(LoanApplication application, @MappingTarget Client client){
        client.addApplication(applicationMapper.toApplicationEntity(application));
        client.addGuarantor(applicationMapper.toApplicationEntity(application));
    }

    @AfterMapping
    void addPhoneInformation(@MappingTarget Client client, LoanApplication application){
        client.addPhone(phoneMapper.toPhoneEntity(application.getApplicant()));
        client.addPhone(phoneMapper.toPhoneEntity(application.getGuarantor()));
    }

}
