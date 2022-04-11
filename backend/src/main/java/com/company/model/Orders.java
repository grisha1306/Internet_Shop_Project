package com.company.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    @Column(name = "id")
    private Integer Id;

    @ManyToOne(fetch = FetchType.EAGER )
//    @JoinColumn(name = "product_id", insertable = false, updatable = false)
//    @Column(name = "product_id")
    private Objects product;

    @ManyToOne(fetch = FetchType.EAGER)
//    @Column(name = "user_id")
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Objects user;

    public Orders() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Objects getProduct() {
        return product;
    }

    public void setProduct(Objects object) {
        this.product = object;
    }

    public Objects getUser() {
        return user;
    }

    public void setUser(Objects user) {
        this.user = user;
    }
}
