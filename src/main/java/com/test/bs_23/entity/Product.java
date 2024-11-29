package com.test.bs_23.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "YA_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "REGULAR_PRICE")
    private double regularPrice;

    @Column(name = "OFFER_PRICE")
    private double offerPrice;

    @Column(columnDefinition = "text")
    private String image;
}
