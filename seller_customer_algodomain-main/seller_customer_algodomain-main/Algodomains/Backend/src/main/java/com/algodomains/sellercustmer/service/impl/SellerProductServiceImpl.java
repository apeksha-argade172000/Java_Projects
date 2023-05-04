package com.algodomains.sellercustmer.service.impl;

import com.algodomains.sellercustmer.dao.SellerProductDao;
import com.algodomains.sellercustmer.dto.SellerProductDto;
import com.algodomains.sellercustmer.model.SellerProductModel;
import com.algodomains.sellercustmer.service.SellerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerProductServiceImpl implements SellerProductService {

    @Autowired
    private SellerProductDao sellerProductDao;

//     <------------------------Seller add one or may product------------------------------>
    @Override
    public Boolean SellerAddProduct(SellerProductDto sellerProductDto) {

        SellerProductModel sellerProductModel =new SellerProductModel();
        sellerProductModel.setSproid(sellerProductDto.getSproid());
        sellerProductModel.setProname(sellerProductDto.getProname());
        sellerProductModel.setProcategory(sellerProductDto.getProcategory());
        sellerProductModel.setProtype(sellerProductDto.getProtype());
        sellerProductModel.setProprice(sellerProductDto.getProprice());
        sellerProductModel.setFild1(sellerProductDto.getFild1());
        sellerProductModel.setFild2(sellerProductDto.getFild2());
        sellerProductModel.setFild3(sellerProductDto.getFild3());
        sellerProductModel.setFild4(sellerProductDto.getFild4());


        Boolean flag=sellerProductDao.sellerAddProduct(sellerProductModel);
        return flag;
    }


//     <--------------------------------------- Seller Can view product list------------------------------------->

    @Override
    public List getData() {

        List list =sellerProductDao.getAlldata() ;
        return list;
    }



    //     <--------------------------------------- Seller Can update product list------------------------------------->
    @Override
    public SellerProductDto updateProduct(Integer id) {
   SellerProductDto sellerProductDto = sellerProductDao.updateProduct(id);
        return sellerProductDto;
    }


    //     <--------------------------------------- Seller Can update product list------------------------------------->
    @Override
    public Boolean DeleteRecord(Integer id) {
        Boolean flag=sellerProductDao.DeletProductRecord(id);
        return flag;
    }
}
