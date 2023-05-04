package com.library.store.dao.Impl;


import com.library.store.dao.BookDao;
import com.library.store.model.BookModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Boolean insertBookData(BookModel bookModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(bookModel);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getBookDao() {
        Session session=null;
        List list=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select book.bid as bid,book.bname as bname,book.bprice as bprice,book.bauthorname as bauthorname from BookModel as book ");
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;

    }

    @Override
    public Boolean deleteBookDao(Integer bid) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            Query query= session.createQuery("delete from BookModel as book where book.bid=:bid");
            query.setParameter("bid",bid);
            query.executeUpdate();
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List bookNameDao(BookModel bookModel) {
        Session session = null;
        List list = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select book.bid as bid,book.bname as bname,book.bprice as bprice,book.bcategory as bcategory,book.bauthorname as bauthorname from BookModel as book where book.bname=:bname");
            query.setParameter("bname",bookModel.getBname());
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }
}
