package com.danila.applications.mappers;

import com.danila.applications.entities.Application;
import com.danila.applications.model.LoanApplication;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ClientMapper.class)
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    @Mapping(source = "number", target = "applicationNumber")
    @Mapping(source = "applicant", target = "applicant")
    Application toApplicationEntity(LoanApplication application);

    @Mapping(source = "applicationNumber", target = "number")
    LoanApplication fromApplicationEntity(Application application);

    @AfterMapping
    default void addApplicantToApplication(@MappingTarget LoanApplication application, Application appEntity) {
        application.setApplicant(ClientMapper.INSTANCE.fromClientEntity(appEntity.getApplicant()));
        application.setGuarantor(ClientMapper.INSTANCE.fromClientEntity(appEntity.getGuarantor()));
    }

}
