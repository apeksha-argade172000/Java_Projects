package com.algodomains.sellercustmer.dao;

import com.algodomains.sellercustmer.dto.SellerProductDto;
import com.algodomains.sellercustmer.model.SellerProductModel;

import java.util.List;

public interface SellerProductDao {
    Boolean sellerAddProduct(SellerProductModel sellerProductModel);

    List getAlldata();

    SellerProductDto updateProduct(Integer id);

    Boolean DeletProductRecord(Integer id);
}
