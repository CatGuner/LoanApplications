package com.danila.applications.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Size;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    String firstName;
    String lastName;

    @Size(max = 10)
    String passport;

    @Size(max = 11)
    String mobilePhone;

    @Size(max = 11)
    String homePhone;
}