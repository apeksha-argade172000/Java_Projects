package com.industry.employee.dao.Impl;

import com.industry.employee.dao.EmployeeDao;
import com.industry.employee.dto.EmployeeDto;
import com.industry.employee.model.EmployeeModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean insertEmpDataDao(EmployeeModel employeeModel) {
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(employeeModel);
            transaction.commit();
            return true;

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getDeptDao(Integer indId) {
        Session session=null;
        List list=null;
        try{
            session=sessionFactory.openSession();
            Query query= session.createQuery("select dept.deptid as deptid,dept.name as name,dept.ind.name as indname from DepartmentModel as dept where dept.ind.indId=:indId");
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

    @Override
    public List getEmpDao() {
        Session session=null;
        List list=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select emp.empid as empid,emp.empname as empname,emp.addr as addr,emp.contact as contact,emp.dob as dob,emp.ind.name as indusname,emp.dept.name as deptname from EmployeeModel as emp ");
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
    public List getEmpListDao(Integer deptid) {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select emp.empid as empid,emp.empname as empname,emp.addr as addr,emp.contact as contact,emp.dob as dob,emp.ind.name as indusname,emp.dept.name as deptname from EmployeeModel as emp where emp.dept.deptid=:deptid");
            query.setParameter("deptid",deptid);
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
    public EmployeeDto editEmpDao(Integer empid) {
        Session session=null;
        EmployeeDto employeeDto=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select emp.empid as empid,emp.empname as empname,emp.addr as addr,emp.contact as contact,emp.dob as dob from EmployeeModel as emp where emp.empid=:empid");
            query.setParameter("empid",empid);
            query.setResultTransformer(Transformers.aliasToBean(EmployeeDto.class));
            employeeDto= (EmployeeDto) query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return employeeDto;
    }

    @Override
    public Boolean deleteEmpDao(Integer empid) {
        Session session=null;
        try {
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            Query query= session.createQuery("delete from EmployeeModel as emp where emp.empid=:empid");
            query.setParameter("empid",empid);
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
