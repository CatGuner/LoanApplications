package com.danila.applications.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Phone{

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    Client client;

    String type;

    @Column(length = 11)
    Long phoneNumber;
}
