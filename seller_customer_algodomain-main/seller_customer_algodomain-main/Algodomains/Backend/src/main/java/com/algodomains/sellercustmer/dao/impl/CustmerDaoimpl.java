package com.algodomains.sellercustmer.dao.impl;

import com.algodomains.sellercustmer.dao.CustmerDao;
import com.algodomains.sellercustmer.dto.CustmerDto;
import com.algodomains.sellercustmer.dto.SellerProductDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustmerDaoimpl implements CustmerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SellerProductDto> GetSearchRecord(CustmerDto custmerDto) {
         List<SellerProductDto> list=null;
         Session session = null;

         try{
             session=sessionFactory.openSession();
             Query query = session.createQuery("select spm.proname as proname,spm.sproid as sproid,spm.procategory as procategory,spm.protype as protype,spm.proprice as proprice from SellerProductModel as spm where spm.proname=:proname" +
                     " and spm.procategory=:category" +
                     " and spm.proprice between :minprice and :maxprice" +
                     " and spm.protype=:type");
             query.setParameter("category",custmerDto.getCategory());
             query.setParameter("type",custmerDto.getType());
             query.setParameter("minprice",custmerDto.getMinprice());
             query.setParameter("maxprice",custmerDto.getMaxprice());
             query.setParameter("proname",custmerDto.getProname());
             query.setResultTransformer(Transformers.aliasToBean(SellerProductDto.class));
                list =query.list();
                return list;
         }
         catch(Exception e){
             e.printStackTrace();

         }
         finally {
             session.close();
         }
        return list;
    }
}
