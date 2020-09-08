package com.danila.applications.mappers;

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


}
