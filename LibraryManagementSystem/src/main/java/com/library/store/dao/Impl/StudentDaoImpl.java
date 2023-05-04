package com.library.store.dao.Impl;


import com.library.store.dao.StudentDao;
import com.library.store.model.BookModel;
import com.library.store.model.StudentModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {


    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Boolean insertStudData(StudentModel studentModel, BookModel bookModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(studentModel);
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
    public List getStudDao() {
        Session session=null;
        List list=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select stud.sid as sid,stud.sname as sname,stud.saddress as saddress,stud.scontact as scontact,stud.semail as semail from StudentModel as stud ");
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
    public Boolean deleteStudDao(Integer sid) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            Query query= session.createQuery("delete from StudentModel as stud where stud.sid=:sid");
            query.setParameter("sid",sid);
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
    public List studentNameDao(StudentModel studentModel) {
        Session session = null;
        List list = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select stud.sid as sid,stud.sname as sname,stud.sbranch as sbranch,stud.saddress as saddress,stud.scontact as scontact,stud.semail as semail from StudentModel as stud where stud.sname=:sname");
            query.setParameter("sname",studentModel.getSname());
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

