package com.danila.applications.service;

import com.danila.applications.data.EntityData;
import com.danila.applications.data.InputData;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.repositories.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ApplicationServiceImplTest {

    @Mock
    ApplicationRepository repository;

    @InjectMocks
    ApplicationServiceImpl applicationService;

    @Test
    void save() {
        LoanApplication application = InputData.createLoanApplication();
        applicationService.save(application);
        Mockito.verify(repository).save(argThat(app ->
                app.getApplicant().getPhones().stream().allMatch(phone ->
                        phone.getClient().equals(app.getApplicant()))
                        && app.getGuarantor().getPhones().stream().allMatch(phone ->
                        phone.getClient().equals(app.getGuarantor()))));
    }

    @Test
    void getApplicationEntity() {
        when(applicationService.getApplicationEntity(any())).thenReturn(EntityData.createApplicationEntity());
        applicationService.getApplicationEntity(3L);
        Mockito.verify(repository).getByApplicationNumber(3L);
    }
}