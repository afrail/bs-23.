package com.test.bs_23.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "YA_ORDER_LINE")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "ACTIVE", columnDefinition = "boolean default true")
    private Boolean active = true;

    @ManyToOne
    private Product product;

    private int qty;

    private double subTotal;

    @ManyToOne
    private Order order;

    private double unitPrice;
}
