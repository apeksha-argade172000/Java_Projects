package com.college.project.service.impl;

import com.college.project.dao.StudDao;
import com.college.project.dto.StudDto;
import com.college.project.dto.StudResDto;
import com.college.project.dto.SubjectDto;
import com.college.project.model.StudModel;
import com.college.project.model.StudSubjectModel;
import com.college.project.model.SubjectModel;
import com.college.project.service.Studservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudServiceImpl implements Studservice {
    @Autowired
    private StudDao studDao;

    @Override
    public boolean insertStudService(StudDto studDto) {
        StudModel studModel = new StudModel();
        studModel.setStudid(studDto.getStudid());
        studModel.setName(studDto.getName());
        studModel.setAddr(studDto.getAddr());
        studModel.setContact(studDto.getContact());
        studModel.setDob(studDto.getDob());
        studModel.setGender(studDto.getGender());
        studModel.setInst(studDto.getInst());


        boolean flag = studDao.inserStudDao(studModel);

        System.out.println("Studentid>>" + studModel.getStudid());


        /* Ethe third table cha object create karayacha */

        for (SubjectDto subjectDto : studDto.getSubjectModelList()) {

            SubjectModel subjectModel = new SubjectModel();
            subjectModel.setSubid(subjectDto.getId());

            StudSubjectModel studSubjectModel = new StudSubjectModel();
            studSubjectModel.setStudModel(studModel);
            studSubjectModel.setSubjectModel(subjectModel);

            flag = studDao.inserStudSubDao(studSubjectModel);

            System.out.println("Subjectid>>>" + subjectDto.getId());
        }

        return flag;
    }

    @Override
    public List getStudService() {
        List list = studDao.getStudDao();
        return list;
    }

    @Override
    public StudResDto editStudService(Integer studid) {
        StudResDto studResDto = studDao.editStudDao(studid);
        return studResDto;
    }

    @Override
    public List getStudListService(Integer id) {
        List list = studDao.getStudListDao(id);

        return list;
    }

    @Override
    public List getNewStudListService(Integer clgId) {
        List list = studDao.getNewStudListDao(clgId);

        return list;
    }

    @Override
    public Boolean deleteStudService(Integer studid) {
        Boolean flag=studDao.deleteStudDao(studid);
        return flag;
    }
}
