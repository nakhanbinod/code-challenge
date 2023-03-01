package com.example.codechallenge.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "batteries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Batteries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String postCode;
    private String watt;


}
