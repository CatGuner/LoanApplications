package com.danila.applications.mappers;

import com.danila.applications.entities.Application;
import com.danila.applications.model.LoanApplication;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    Application toApplicationEntity(LoanApplication application);

    @AfterMapping
    default void addApplicant(@MappingTarget Application appEntity, LoanApplication application){
        appEntity.setApplicant(ClientMapper.INSTANCE.toClientEntity(application.getApplicant()));
    }

    @AfterMapping
    default void addGuarantor(@MappingTarget Application appEntity, LoanApplication application){
        appEntity.setGuarantor(ClientMapper.INSTANCE.toClientEntity(application.getGuarantor()));
    }

}
