package com.danila.applications.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class LoanApplication {
    Integer applicationNumber;
    Integer amount;
    String currency;
    @Autowired
    Applicant applicant;
    @Autowired
    Guarantor guarantor;
}

