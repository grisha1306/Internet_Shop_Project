package com.company.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
@Data
public class Parameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    @Column(name = "parameter_id")
    private Integer parameterId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id")
    private Objects objectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private Attributes attributeId;

    @Column(name = "value")
    private String value;

    public Parameters() {
    }

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public Objects getObjectId() {
        return objectId;
    }

    public void setObjectId(Objects objectId) {
        this.objectId = objectId;
    }

    public Attributes getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return java.util.Objects.equals(parameterId, that.parameterId) && java.util.Objects.equals(objectId, that.objectId) && java.util.Objects.equals(attributeId, that.attributeId) && java.util.Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(parameterId, objectId, attributeId, value);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "parameterId=" + parameterId +
                ", objectId=" + objectId +
                ", attributeId=" + attributeId +
                ", value='" + value + '\'' +
                '}';
    }
}
