package com.danila.applications.entities;

import lombok.Data;

import javax.persistence.Entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue
    Integer id;

    Long applicationNumber;

    Long amount;

    String currency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id")
    Client applicant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guarantor_id")
    Client guarantor;
}
