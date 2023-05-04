package com.industry.employee.dao.Impl;

import com.industry.employee.dao.RegistrationDao;
import com.industry.employee.model.RegistrationModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Boolean insertRegistrationDao(RegistrationModel registrationModel) {
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            session.saveOrUpdate(registrationModel);
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
}
