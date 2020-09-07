package com.danila.applications.mappers;

import com.danila.applications.entities.Application;
import com.danila.applications.model.LoanApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ApplicationMapper {

    @Mappings({
            @Mapping(source = "applicationNumber", target = "applicationNumber"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "currency", target = "currency")
    })
    Application toApplicationEntity(LoanApplication application);
}
