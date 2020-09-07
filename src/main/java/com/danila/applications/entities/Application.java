package com.danila.applications.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {

    @Id
    @GeneratedValue
    Integer id;

    Long applicationNumber;

    Long amount;

    Long currency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id")
    Client applicant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guarantor_id")
    Client guarantor;
}
