package com.company.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Parameters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parameter_id")
    private Integer parameterId;

    @Column(name = "object_id")
    private Integer objectId;

    @Column(name = "attribute_id")
    private Integer attributeId;

    @Column(name = "value")
    private String value;
}
