package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "attributes")
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private Integer id;

    @Column(name = "attribute_name")
    private String attributeName;



}
