package com.company.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "objects")
public class Objects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer objectId;

    @Column(name = "object_name")
    private String objectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_type")
    private ObjectsType objectType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Objects parent_id;

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

    public ObjectsType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectsType objectType) {
        this.objectType = objectType;
    }

    public Objects getParent_id() {
        return parent_id;
    }

    public void setParent_id(Objects parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objects objects = (Objects) o;
        return java.util.Objects.equals(objectId, objects.objectId) && java.util.Objects.equals(objectName, objects.objectName) && java.util.Objects.equals(objectType, objects.objectType) && java.util.Objects.equals(parent_id, objects.parent_id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(objectId, objectName, objectType, parent_id);
    }

    @Override
    public String toString() {
        return "Objects{" +
                "objectId=" + objectId +
                ", objectName='" + objectName + '\'' +
                ", objectType=" + objectType +
                ", parent_id=" + parent_id +
                '}';
    }
}
