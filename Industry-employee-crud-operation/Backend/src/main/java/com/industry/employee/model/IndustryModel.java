package com.industry.employee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "industry_table")
public class IndustryModel {
    @Id
    @Column(name = "industry_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer indId;

    @Column(name = "industry_name")
    private String name;

    @Column(name = "industry_address")
    private String addr;

    @Column(name = "industry_contact")
    private String contact;
}
