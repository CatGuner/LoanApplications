package com.danila.applications.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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
    Set<Application> applicats;

    @OneToMany(mappedBy = "guarantor")
    @PrimaryKeyJoinColumn
    Set<Application> guarantors;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<Phone> phones = new LinkedList<>();

    public void addPhone(Phone phone){
        phones.add(phone); }

}
