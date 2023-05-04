package com.library.store.service.Impl;

import com.library.store.dao.StudentDao;
import com.library.store.dto.Libstuddto;
import com.library.store.model.BookModel;
import com.library.store.model.StudentModel;
import com.library.store.service.BookService;
import com.library.store.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Boolean insertStudentService(Libstuddto libstuddto) {

       StudentModel studentModel = new StudentModel();
       studentModel.setSid(libstuddto.getSid());
       studentModel.setSname(libstuddto.getSname());
       studentModel.setSaddress(libstuddto.getSaddress());
       studentModel.setSemail(libstuddto.getSemail());
       studentModel.setScontact(libstuddto.getScontact());
       studentModel.setSbranch(libstuddto.getSbranch());

        BookModel bookModels=new BookModel();

        bookModels.setStudent(libstuddto.getSid());
        System.out.println("==>"+libstuddto.getSid());
        bookModels.setBname(libstuddto.getBname());
        bookModels.setBprice(libstuddto.getBprice());
        bookModels.setBcategory(libstuddto.getBcategory());
        bookModels.setBauthorname(libstuddto.getBauthorname());
        Boolean flag=studentDao.insertStudData(studentModel,bookModels);
        return flag;
    }

    @Override
    public List getStudentService() {
        List list=studentDao.getStudDao();
        return list;
    }

    @Override
    public Boolean deletStudentService(Integer sid) {
        Boolean flag=studentDao.deleteStudDao(sid);
        return flag;
    }

    @Override
    public List getStudentNameService(StudentModel studentModel) {
        List list=studentDao.studentNameDao(studentModel);
        return list;
    }
}
