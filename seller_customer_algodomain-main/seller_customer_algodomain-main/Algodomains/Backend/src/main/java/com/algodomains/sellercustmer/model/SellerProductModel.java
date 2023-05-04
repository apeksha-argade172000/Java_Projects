package com.algodomains.sellercustmer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="product_table")
public class SellerProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Integer sproid;

    @Column(name="product_name")
    private String proname;

    @Column(name="product_category")
    private String procategory;

    @Column(name="product_type")
    private String protype;

    @Column(name="product_price")
    private Double proprice;

    @Column(name="fild1")
    private String fild1;

    @Column(name="fild2")
    private String fild2;

    @Column(name="fild3")
    private String fild3;

    @Column(name="fild4")
    private String fild4;
}
