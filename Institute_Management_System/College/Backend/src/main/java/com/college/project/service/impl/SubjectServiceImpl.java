package com.college.project.service.impl;

import com.college.project.dao.SubjectDao;
import com.college.project.dto.SubjectDto;
import com.college.project.dto.SubjectResDto;
import com.college.project.model.SubjectModel;
import com.college.project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    @Override
    public Boolean insertSubService(SubjectDto subjectDto) {
        SubjectModel subjectModel=new SubjectModel();
        subjectModel.setSubid(subjectDto.getSubid());
        subjectModel.setSubname(subjectDto.getSubname());
        subjectModel.setInst(subjectDto.getInst());
        Boolean flag=subjectDao.insertSubjectDao(subjectModel);
        return flag;
    }

    @Override
    public List getSubjectService(Integer clgId) {
        List list=subjectDao.getSubjectDao(clgId);
        return list;
    }

    @Override
    public SubjectResDto editSubService(Integer subid) {
        SubjectResDto subjectResDto=subjectDao.editSubjectDao(subid);
        return  subjectResDto;
    }

    @Override
    public Boolean deleteSubService(Integer subid) {
        Boolean flag=subjectDao.deleteSubDao(subid);
        return flag;
    }

    @Override
    public List getSubService() {
        List list = subjectDao.getSubDao();
        return list;
    }
}
