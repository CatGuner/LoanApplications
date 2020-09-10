package com.danila.applications.service;

import com.danila.applications.entities.Application;
import com.danila.applications.mappers.ApplicationMapper;
import com.danila.applications.model.LoanApplication;
import com.danila.applications.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public Application getApplicationEntity(Long number) {
        return applicationRepository.getByApplicationNumber(number);
    }

    @Override
    public List getAll() {
        return (List) applicationRepository.findAll();
    }

    @Override
    public void save(LoanApplication loanApplication) {
        Application application = ApplicationMapper.INSTANCE.toApplicationEntity(loanApplication);
        connectPhoneNumbersWithClients(application);
        this.applicationRepository.save(application);
    }

    private void connectPhoneNumbersWithClients(Application application) {
        application.getApplicant().getPhones().forEach(phone -> phone.setClient(application.getApplicant()));
        application.getGuarantor().getPhones().forEach(phone -> phone.setClient(application.getGuarantor()));
    }
}
