package com.library.store.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookDto {

    private Integer bid;
    private String bname;
    private Double bprice;
    private String bcategory;
    private String bauthorname;
}
