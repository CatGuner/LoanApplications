package com.danila.applications.mappers;

import com.danila.applications.entities.Phone;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.model.Person;
import org.mapstruct.*;

@Mapper
public interface PhoneMapper {

    public Phone toPhoneEntity(Person person);

    @AfterMapping
    default void typeInit(@MappingTarget Phone phone, Person person){
        if (person.getMobilePhone() != null){
            phone.setType("MOBILE");
            phone.setPhoneNumber(Integer.parseInt(person.getMobilePhone()));
        } else if (person.getHomePhone() != null){
            phone.setType("HOME");
            phone.setPhoneNumber(Integer.parseInt(person.getHomePhone()));
        }
    }
}
