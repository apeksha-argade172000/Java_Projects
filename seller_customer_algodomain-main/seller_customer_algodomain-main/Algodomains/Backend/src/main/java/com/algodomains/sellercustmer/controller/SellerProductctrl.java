package com.algodomains.sellercustmer.controller;

import com.algodomains.sellercustmer.dto.ResponceVo;
import com.algodomains.sellercustmer.dto.SellerProductDto;
import com.algodomains.sellercustmer.service.SellerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SellerProductctrl {

    @Autowired
    private SellerProductService sellerProductService;


//    <------------------------Seller add one or may product------------------------------>
    @PostMapping(value="selleraddproduct")
    public Boolean Addproduct(@RequestBody SellerProductDto sellerProductDto){

        Boolean flag = sellerProductService.SellerAddProduct(sellerProductDto);

        if(flag==true)
            return flag;

        else
            return flag;
    }


//   <--------------------------------------- Seller Can view product list------------------------------------->

    @GetMapping(value="getproductdata")
    public ResponceVo<List> GetAlldata(){

        ResponceVo responceVo = new ResponceVo();

        List list =sellerProductService.getData();

        if(list.size()!=-0){
            responceVo.setResult(list);
            responceVo.setStatusCode(String.valueOf(HttpStatus.OK));
            responceVo.setMeassage("Product Data Found");
            return responceVo;
        }
        else{
            responceVo.setMeassage("Product Data not Found");
            responceVo.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));

            return responceVo;
        }
    }


//    <--------------------------------------- Seller Can update product list------------------------------------->
    @GetMapping(value = "updateproduct/{id}")
    public ResponceVo<SellerProductDto> UpdatesellerProduct(@PathVariable Integer id){

        ResponceVo responceVo = new ResponceVo();

        SellerProductDto sellerProductDto = sellerProductService.updateProduct(id);

        if(sellerProductDto != null){
            System.out.println("Selected id for update >>>>"+id);
            responceVo.setMeassage("data Found To upadte");
            responceVo.setStatusCode(String.valueOf(HttpStatus.OK));
            responceVo.setResult(sellerProductDto);
            return responceVo;
        }
        else {
            responceVo.setMeassage("data Not Found To upadte");
            responceVo.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));


            return responceVo;
        }
    }

//    <--------------------------------------- Seller Can delete product list------------------------------------->

    @DeleteMapping(value="DeleteProductRecord/{id}")
    public ResponceVo<Boolean> DeleteRecordCtrl(@PathVariable Integer id){

        ResponceVo responceVo = new ResponceVo();

        Boolean flag = sellerProductService.DeleteRecord(id);

        if(flag){
            System.out.println("Select id for delete record is>>>"+id);
            responceVo.setMeassage("Data Delete Succsesfully");
            responceVo.setStatusCode(String.valueOf(HttpStatus.OK));

            return responceVo;
        }
        else{
            responceVo.setMeassage("data Not Delete");
            responceVo.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            return responceVo;
        }
    }

}
