package com.college.project.dao.impl;

import com.college.project.dao.SubjectDao;
import com.college.project.dto.StudResDto;
import com.college.project.dto.SubjectResDto;
import com.college.project.model.SubjectModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDaoImpl implements SubjectDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean insertSubjectDao(SubjectModel subjectModel) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(subjectModel);
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
    public List getSubjectDao(Integer clgId) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query= session.createQuery("select sub.subid as id,sub.subname as label,sub.inst.name as instname from SubjectModel as sub where sub.inst.clgId=:clgId");
            query.setParameter("clgId",clgId);
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
    public SubjectResDto editSubjectDao(Integer subid) {
        Session session=null;
        SubjectResDto subjectResDto=null;
        try
        {
            session=sessionFactory.openSession();
            Query query= session.createQuery("select sub.subid as subid,sub.subname as subname,sub.inst as inst from SubjectModel as sub where sub.subid=:subid");
            query.setParameter("subid",subid);
            query.setResultTransformer(Transformers.aliasToBean(SubjectResDto.class));
            subjectResDto= (SubjectResDto) query.uniqueResult();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return subjectResDto;
    }

    @Override
    public Boolean deleteSubDao(Integer subid) {
        Session session=null;

        try{
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            Query query=session.createQuery("delete from SubjectModel as sub where sub.subid=:subid");
            query.setParameter("subid",subid);
            query.executeUpdate();
            transaction.commit();
            return true;

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

    @Override
    public List getSubDao() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
              Query query= session.createQuery("select sub.subid as subid,sub.subname as subname,sub.inst.name as instname from SubjectModel as sub");
//            Query query= session.createQuery("from SubjectModel");
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

}
