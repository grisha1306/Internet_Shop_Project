package com.company.model;

import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Entity
@Data
public class References {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_id")
    private Integer referenceId;

    @Column(name = "attribute_id")
    private Integer attributeId;

    @Column(name = "object_id")
    private Integer objectId;

}
