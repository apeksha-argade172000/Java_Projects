package com.algodomains.sellercustmer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponceVo <T> {

    private String meassage;

    private String StatusCode;

    private T result;
}
