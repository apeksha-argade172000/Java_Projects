package com.algodomains.sellercustmer.controller;

import com.algodomains.sellercustmer.dto.CustmerDto;
import com.algodomains.sellercustmer.dto.ResponceVo;
import com.algodomains.sellercustmer.dto.SellerProductDto;
import com.algodomains.sellercustmer.service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustmerCtrl {

    @Autowired
    private CustmerService custmerService;


    @PostMapping(value="searchproduct")
    public ResponceVo<List> SearchCtrl(@RequestBody CustmerDto custmerDto){

        ResponceVo responceVo = new ResponceVo();

        List<SellerProductDto> list = custmerService.SearchList(custmerDto);

        if(list.size()!=0){
            responceVo.setResult(list);
            responceVo.setStatusCode(String.valueOf(HttpStatus.OK));
            responceVo.setMeassage("Search List Found");
            return responceVo;
        }
        else{
            responceVo.setMeassage("Search List Found");
            responceVo.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            return responceVo;
        }
    }
}
