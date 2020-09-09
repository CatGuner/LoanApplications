package com.danila.applications.mappers;

import com.danila.applications.entities.Client;
import com.danila.applications.entities.Phone;
import com.danila.applications.model.Person;
import org.mapstruct.*;
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
    default void convertPhones(@MappingTarget Person person, Client client){
        for (Phone item : client.getPhones()){
            if ("MOBILE".equals(item.getType())){
                person.setMobilePhone(item.getPhoneNumber().toString());
            } else if ("HOME".equals(item.getType())){
                person.setHomePhone(item.getPhoneNumber().toString());
            }
        }
    }
}
