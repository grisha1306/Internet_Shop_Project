package com.company.model;

import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Entity
@Table(name = "references")
@Data
public class References {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_id")
    private Integer referenceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id")
    private Objects productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private Attributes attributeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id")
    private Objects userId;

    public References() {
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Objects getProductId() {
        return productId;
    }

    public void setProductId(Objects productId) {
        this.productId = productId;
    }

    public Attributes getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    public Objects getUserId() {
        return userId;
    }

    public void setUserId(Objects userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        References that = (References) o;
        return java.util.Objects.equals(referenceId, that.referenceId) && java.util.Objects.equals(productId, that.productId) && java.util.Objects.equals(attributeId, that.attributeId) && java.util.Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(referenceId, productId, attributeId, userId);
    }

    @Override
    public String toString() {
        return "References{" +
                "referenceId=" + referenceId +
                ", productId=" + productId +
                ", attributeId=" + attributeId +
                ", userId=" + userId +
                '}';
    }
}
