package com.company.model;

public class ProductInfo {
    private String value;
    private String attributeName;

    public ProductInfo(String value, String attributeName) {
        this.value = value;
        this.attributeName = attributeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
