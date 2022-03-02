package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "attributes")
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private Integer id;

    @Column(name = "attribute_name")
    private String attributeName;


    public Attributes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributes that = (Attributes) o;
        return Objects.equals(id, that.id) && Objects.equals(attributeName, that.attributeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attributeName);
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "id=" + id +
                ", attributeName='" + attributeName + '\'' +
                '}';
    }
}
