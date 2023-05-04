package com.library.store.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "b_Id")
    private Integer bid;

    @Column(name = "b_Name")
    private String bname;

    @Column(name = "b_Price")
    private Double bprice;

    @Column(name = "b_Category")
    private String bcategory;

    @Column(name = "b_AuthorName")
    private String bauthorname;

    private Integer student;


}

