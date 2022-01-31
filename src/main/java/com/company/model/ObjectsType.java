package com.company.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ObjectsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_type_id")
    private Integer objectTypeId;

    @Column(name = "type_name")
    private String typeName;


}
