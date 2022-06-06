package com.company.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "objects")
@Data
public class Objects {

    @Id
    @Column(name = "object_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private Integer objectId;

    @Column(name = "object_name")
    private String objectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_type")
    private ObjectType objectType;

    public Objects() {
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objects objects = (Objects) o;
        return java.util.Objects.equals(objectId, objects.objectId) && java.util.Objects.equals(objectName, objects.objectName) && java.util.Objects.equals(objectType, objects.objectType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(objectId, objectName, objectType);
    }

    @Override
    public String toString() {
        return "Objects{" +
                "objectId=" + objectId +
                ", objectName='" + objectName + '\'' +
                ", objectType=" + objectType +
                '}';
    }
}
