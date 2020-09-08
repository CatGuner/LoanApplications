package com.danila.applications.mappers;


import com.danila.applications.entities.Client;
import com.danila.applications.model.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ClientMapper {

    public static ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    public abstract Client toClientEntity(Person person);


    @AfterMapping
    void parsePassword(@MappingTarget Client client, Person person){
        client.setPassportSeries(Integer.parseInt(person.getPassport().substring(0,4)));
        client.setPassportNumber(Integer.parseInt(person.getPassport().substring(4)));
    }

    @AfterMapping
    void addHomePhone(@MappingTarget Client client, Person person){
        client.addPhone(PhoneMapper.INSTANCE.toHomePhoneEntity(person));
        client.addPhone(PhoneMapper.INSTANCE.toMobilePhoneEntity(person));
    }

}
