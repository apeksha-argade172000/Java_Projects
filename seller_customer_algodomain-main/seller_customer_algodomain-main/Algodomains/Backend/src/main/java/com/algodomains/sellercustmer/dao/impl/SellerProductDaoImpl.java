package com.algodomains.sellercustmer.dao.impl;

import com.algodomains.sellercustmer.dao.SellerProductDao;
import com.algodomains.sellercustmer.dto.SellerProductDto;
import com.algodomains.sellercustmer.model.SellerProductModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class SellerProductDaoImpl implements SellerProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean sellerAddProduct(SellerProductModel sellerProductModel) {
        Session session= null;
        try{
            session=sessionFactory.openSession();
            Transaction t =session.beginTransaction();
            session.saveOrUpdate(sellerProductModel);
            t.commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

//    <--------------------------------------- Seller Can view product list------------------------------------->


    @Override
    public List getAlldata() {
        List list = null;
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("from SellerProductModel sp");
            list=(List)query.list();
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


//    <--------------------------------------- Seller Can update product list------------------------------------->
    @Override
    public SellerProductDto updateProduct(Integer id) {
        SellerProductDto sellerProductDto = null;
        Session session= null;
        try{
            session=sessionFactory.openSession();
            Query query = session.createQuery("select sp.sproid as sproid, sp.proname as proname, sp.procategory as procategory,sp.protype as protype,sp.proprice as proprice,sp.fild1 as fild1,sp.fild2 as fild2,sp.fild3 as fild3,sp.fild4 as fild4 from SellerProductModel as sp where sp.sproid=:id");
            query.setParameter("id",id);
            query.setResultTransformer(Transformers.aliasToBean(SellerProductDto.class));
            sellerProductDto= (SellerProductDto) query.uniqueResult();
            return sellerProductDto;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return sellerProductDto;
    }


//  <--------------------------------------- Seller Can delete product list------------------------------------->
    @Override
    public Boolean DeletProductRecord(Integer id) {
        Session session = null;
        try{
            session=sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Query query = session.createQuery("delete  from SellerProductModel as sp where sp.sproid=:id");
            query.setParameter("id",id);
            query.executeUpdate();
            t.commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }

    }
}
