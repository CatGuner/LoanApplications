package com.danila.applications.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {

    @Id
    @GeneratedValue
    Long id;

    String firstName;

    String lastName;

    @Column(length = 4)
    Integer passportSeries;

    @Column(length = 6)
    Integer passportNumber;

    @OneToMany(mappedBy = "applicant")
    @PrimaryKeyJoinColumn
    Set<Application> applications;

    @OneToMany(mappedBy = "guarantor")
    @PrimaryKeyJoinColumn
    Set<Application> guarantors;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    Set<Phone> phones;

    public void addApplication(Application app){ applications.add(app); }

    public void addGuarantor(Application gua){ guarantors.add(gua); }

    public void addPhone(Phone phone){ phones.add(phone); }

}
