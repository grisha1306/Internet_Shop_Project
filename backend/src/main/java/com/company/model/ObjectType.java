package com.company.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "object_types")
@Data
public class ObjectType {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    @Column(name = "object_type_id")
    private Integer objectTypeId;

    @Column(name = "type_name")
    private String typeName;

    public ObjectType() {
    }

    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectType that = (ObjectType) o;
        return Objects.equals(objectTypeId, that.objectTypeId) && Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectTypeId, typeName);
    }

    @Override
    public String toString() {
        return "ObjectsType{" +
                "objectTypeId=" + objectTypeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
