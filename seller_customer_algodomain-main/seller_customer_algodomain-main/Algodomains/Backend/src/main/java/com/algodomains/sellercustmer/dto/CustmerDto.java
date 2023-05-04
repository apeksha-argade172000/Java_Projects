package com.algodomains.sellercustmer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustmerDto {

    private String proname;
    private String type;
    private String category;
    private Double minprice;
    private Double maxprice;
}
