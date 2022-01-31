package com.company.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Objects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer objectId;

    @Column(name = "object_name")
    private String objectName;

    @Column(name = "object_type")
    private Integer objectType;

    @Column(name = "parent_id")
    private Integer parentId;

}
