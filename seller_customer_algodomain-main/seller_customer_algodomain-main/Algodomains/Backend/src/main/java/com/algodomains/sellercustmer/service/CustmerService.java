package com.algodomains.sellercustmer.service;

import com.algodomains.sellercustmer.dto.CustmerDto;
import com.algodomains.sellercustmer.dto.SellerProductDto;

import java.util.List;

public interface CustmerService {
    List<SellerProductDto>SearchList(CustmerDto custmerDto);
}
