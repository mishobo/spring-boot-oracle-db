package com.lctafrica.net.springbootoracle.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name="AGE")
    private int age;

    @Nullable
    @Column(name="ADDRESS")
    private String address;

    @Nullable
    @Column(name="SALARY")
    private Double salary;


}
