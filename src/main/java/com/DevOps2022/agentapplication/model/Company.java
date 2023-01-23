package com.DevOps2022.agentapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private String owner;
    @Column
    private String culture;
    @Column
    private String description;
    @Column
    private String address;
    @Column
    private Boolean status;
    @Column
    private String phoneNumber;
    @Column
    private String emailAddress;
}
