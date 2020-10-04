package com.danila.applications.mappers;

import com.danila.applications.entities.Client;
import com.danila.applications.entities.Phone;
import com.danila.applications.model.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    @Mapping(constant = "HOME", target = "type")
    @Mapping(source = "homePhone", target = "phoneNumber")
    Phone toHomePhoneEntity(Person person);

    @Mapping(constant = "MOBILE", target = "type")
    @Mapping(source = "mobilePhone", target = "phoneNumber")
    Phone toMobilePhoneEntity(Person person);

    void fromPhoneEntity(@MappingTarget Person person, Client client);

    @AfterMapping
    default void convertPhones(@MappingTarget Person person, Client client) {
        client.getPhones().forEach(item -> {
            switch (item.getType()){
                case "HOME":
                    person.setHomePhone(String.valueOf(item.getPhoneNumber()));
                case "MOBILE":
                    person.setMobilePhone(String.valueOf(item.getPhoneNumber()));
            }
        });
    }
}
