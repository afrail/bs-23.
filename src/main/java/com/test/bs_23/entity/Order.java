package com.test.bs_23.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "YA_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "ACTIVE", columnDefinition = "boolean default true")
    private Boolean active = true;

    @ManyToOne
    private User user;

    private String invoiceNo;
    private double totalAmount;
    private double discount;
    private double deliveryCharge;

    private double payableAmount;
    private String couponCode;

    private String orderStatus;
}
