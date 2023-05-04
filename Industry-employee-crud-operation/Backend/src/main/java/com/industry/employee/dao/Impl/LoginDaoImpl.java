package com.industry.employee.dao.Impl;

import com.industry.employee.dao.LoginDao;
import com.industry.employee.dto.LoginDto;
import com.industry.employee.dto.LoginResDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public LoginResDto userLoginDao(LoginDto loginDto) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select user.regid as regid,user.username as username,user.password as password from RegistrationModel as user where user.username=:username");
            query.setParameter("username",loginDto.getUsername());
            query.setResultTransformer(Transformers.aliasToBean(LoginResDto.class));
            LoginResDto loginResDto= (LoginResDto) query.uniqueResult();
            return loginResDto;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }
}
