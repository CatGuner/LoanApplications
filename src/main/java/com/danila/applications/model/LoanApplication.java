package com.danila.applications.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanApplication {
    Long applicationNumber;
    Integer amount;
    String currency;
    Applicant applicant;
    Guarantor guarantor;
}
