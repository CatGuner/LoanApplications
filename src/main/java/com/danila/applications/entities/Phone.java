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
public class Phone{

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    Client client;

    String type;

    Integer phoneNumber;
}
