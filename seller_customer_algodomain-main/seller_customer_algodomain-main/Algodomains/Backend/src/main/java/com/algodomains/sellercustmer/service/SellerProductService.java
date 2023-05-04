package com.algodomains.sellercustmer.service;

import com.algodomains.sellercustmer.dto.SellerProductDto;

import java.util.List;

public interface SellerProductService {
    Boolean SellerAddProduct(SellerProductDto sellerProductDto);

    List getData();

    SellerProductDto updateProduct(Integer id);

    Boolean DeleteRecord(Integer id);
}
