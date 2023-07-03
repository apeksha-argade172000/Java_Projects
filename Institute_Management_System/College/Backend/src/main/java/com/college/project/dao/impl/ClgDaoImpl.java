package com.college.project.dao.impl;

import com.college.project.dao.ClgDao;
import com.college.project.dto.ClgResDto;
import com.college.project.model.ClgModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClgDaoImpl implements ClgDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean insertClgDao(ClgModel clgModel) {
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(clgModel);
            transaction.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List getClgRecordDao() {
        Session session=null;
        List list=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select  clg.clgId as clgId,clg.name as name,clg.addr as addr,clg.contact as contact from ClgModel as clg");
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
    public ClgResDto editCalDao(Integer clgId) {
        Session session=null;
        ClgResDto clgResDto=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select clg.clgId as clgId,clg.name as name,clg.addr as addr,clg.contact as contact from ClgModel as clg where clg.clgId=:clgId");
            query.setParameter("clgId",clgId);
            query.setResultTransformer(Transformers.aliasToBean(ClgResDto.class));
            clgResDto= (ClgResDto) query.uniqueResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return clgResDto;

    }

    @Override
    public Boolean deleteClgDao(Integer clgId) {
        Session session=null;

        try{
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
//            Query query=session.createQuery("delete from ClgModel as clg where clg.clgId=:clgId");
//
//            query.setParameter("clgId",clgId);
//            query.executeUpdate();
//            transaction.commit();
//            return true;


//            String hql = "DELETE FROM ClgModel WHERE clgId = :clgId";
//            session.createQuery(hql)
//                    .setParameter("clgId", clgId)
//                    .executeUpdate();


            String deleteStudSubjectHql = "DELETE FROM StudSubjectModel WHERE studModel IN (SELECT s FROM StudModel s WHERE s.inst.clgId = :clgId)";
            session.createQuery(deleteStudSubjectHql)
                    .setParameter("clgId", clgId)
                    .executeUpdate();



            String deleteStudentsHql = "DELETE FROM StudModel WHERE inst.clgId = :clgId";
            session.createQuery(deleteStudentsHql)
                    .setParameter("clgId", clgId)
                    .executeUpdate();


            String deleteCollegeHql = "DELETE FROM ClgModel WHERE clgId = :clgId";
            session.createQuery(deleteCollegeHql)
                    .setParameter("clgId", clgId)
                    .executeUpdate();








        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return true;
    }
}
