package com.college.project.dao.impl;

import com.college.project.dao.StudDao;
import com.college.project.dto.StudResDto;
import com.college.project.model.StudModel;
import com.college.project.model.StudSubjectModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudDaoImpl implements StudDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean inserStudDao(StudModel studModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(studModel);
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
    public List getStudDao() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query= session.createQuery("select stud.studid as studid,stud.name as name,stud.addr as addr,stud.dob as dob,stud.gender as gender,stud.contact as contact,stud.inst.name as instname from StudModel as stud");
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
    public StudResDto editStudDao(Integer studid) {
        Session session=null;
        StudResDto studResDto=null;
        try
        {
            session=sessionFactory.openSession();
            Query query= session.createQuery("select stud.studid as studid,stud.name as name,stud.addr as addr,stud.dob as dob,stud.gender as gender,stud.contact as contact,stud.inst as inst from StudModel as stud where stud.studid=:studid");
            query.setParameter("studid",studid);
            query.setResultTransformer(Transformers.aliasToBean(StudResDto.class));
            studResDto= (StudResDto) query.uniqueResult();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return studResDto;
    }

    @Override
    public List getStudListDao(Integer id) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query= session.createQuery("select stud.studid as studid,stud.name as name,stud.addr as addr,stud.dob as dob,stud.gender as gender,stud.contact as contact,inst.name as instname,subj.subname as subname from StudSubjectModel as ss INNER JOIN ss.studModel as stud INNER JOIN stud.inst as inst INNER JOIN ss.subjectModel as subj where subj.subid=:id");
            query.setParameter("id",id);
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
    public boolean inserStudSubDao(StudSubjectModel studSubjectModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.save(studSubjectModel);
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
    public List getNewStudListDao(Integer clgId) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query= session.createQuery("select stud.studid as studid,stud.name as name,stud.addr as addr,stud.dob as dob,stud.gender as gender,stud.contact as contact,ins.name as instname,subj.subname as subname from StudSubjectModel as ss INNER JOIN ss.studModel as stud INNER JOIN stud.inst as ins INNER JOIN ss.subjectModel as subj where ins.clgId=:clgId");
            query.setParameter("clgId",clgId);
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
    public Boolean deleteStudDao(Integer studid) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete from StudSubjectModel ss where ss.studModel.studid=:studid");
            query.setParameter("studid", studid);
            int count = query.executeUpdate();
            if (count > 0) {
                Query studQuery = session.createQuery("delete from StudModel stud where stud.studid=:studid");
                studQuery.setParameter("studid", studid);
                studQuery.executeUpdate();
            }
            return true;
        }
//            String subTableDeleteQuery = "DELETE FROM StudSubjectModel WHERE studModel.studid = :studid";
//            Query query = session.createQuery(subTableDeleteQuery);
//            query.setParameter("studid", studid);
//            int subTableResult = query.executeUpdate();
//            return true;
//        }






//            query.executeUpdate();
//            transaction.commit();
//            return true;
//            StudModel studModel = session.get(StudModel.class,studid);
//            if (studModel!=null){
//                session.delete(studModel);
//                System.out.println("==>"+studid);
//
//            }
//            return true;
//        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
