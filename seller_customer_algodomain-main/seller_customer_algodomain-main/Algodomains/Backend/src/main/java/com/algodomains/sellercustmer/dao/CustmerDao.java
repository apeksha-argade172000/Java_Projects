package com.algodomains.sellercustmer.dao;

import com.algodomains.sellercustmer.dto.CustmerDto;
import com.algodomains.sellercustmer.dto.SellerProductDto;

import java.util.List;

public interface CustmerDao {
    List<SellerProductDto> GetSearchRecord(CustmerDto custmerDto);
}
