package com.industry.employee.dao.Impl;

import com.industry.employee.dao.IndustryDao;
import com.industry.employee.dto.IndustryDto;
import com.industry.employee.model.IndustryModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndustryDaoImpl implements IndustryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean insertIndustryDao(IndustryModel industryModel) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            session.saveOrUpdate(industryModel);
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
    public List getIndDataDao() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();

            Query query= session.createQuery("select ind.indId as indId,ind.name as name,ind.addr as addr,ind.contact as contact from IndustryModel as ind");
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public IndustryDto editIndDataDao(Integer indId) {
        Session session=null;
        IndustryDto industryDto=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select ind.indId as indId,ind.name as name,ind.addr as addr,ind.contact as contact from IndustryModel as ind where ind.indId=:indId");
            query.setParameter("indId",indId);
            query.setResultTransformer(Transformers.aliasToBean(IndustryDto.class));
            industryDto= (IndustryDto) query.uniqueResult();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return industryDto;
    }

    @Override
    public Boolean deleteIndDataDao(Integer indId) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            Query query= session.createQuery("delete from IndustryModel as ind where ind.indId=:indId");
            query.setParameter("indId",indId);
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
}
