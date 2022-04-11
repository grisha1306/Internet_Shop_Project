package com.company.model;

public class Product {
    private Integer objectId;
    private String objectName;
    private String typeName;

    public Product(Integer objectId, String objectName, String typeName) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.typeName = typeName;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
    public Product () {}

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}

