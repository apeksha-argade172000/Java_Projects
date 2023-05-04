package com.algodomains.sellercustmer.service.impl;

import com.algodomains.sellercustmer.dao.CustmerDao;
import com.algodomains.sellercustmer.dto.CustmerDto;
import com.algodomains.sellercustmer.dto.SellerProductDto;
import com.algodomains.sellercustmer.service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CustmerServiceimpl implements CustmerService {

    @Autowired
    private CustmerDao custmerDao;


    @Override
    public List<SellerProductDto> SearchList(CustmerDto custmerDto) {
        List<SellerProductDto> list = custmerDao.GetSearchRecord(custmerDto);
        return list;
    }
}
