package com.industry.employee.dao.Impl;

import com.industry.employee.dao.DepartmentDao;
import com.industry.employee.dto.DepartmentDto;
import com.industry.employee.model.DepartmentModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean insertDeptDao(DepartmentModel departmentModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(departmentModel);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getIndWiseDeptDao(Integer indId) {
        Session session=null;
        List list=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("select dept.deptid as deptid,dept.name as deptname from DepartmentModel as dept where dept.ind.indId=:indId");
            query.setParameter("indId",indId);
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
