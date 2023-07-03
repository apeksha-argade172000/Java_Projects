package com.college.project.service.impl;

import com.college.project.dao.ClgDao;
import com.college.project.dto.ClgDto;
import com.college.project.dto.ClgResDto;
import com.college.project.model.ClgModel;
import com.college.project.service.ClgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClgServiceImpl implements ClgService {
    @Autowired
    private ClgDao clgDao;
    @Override
    public boolean insertClgService(ClgDto clgDto) {
        ClgModel clgModel=new ClgModel();
        clgModel.setClgId(clgDto.getClgId());
        clgModel.setName(clgDto.getName());
        clgModel.setAddr(clgDto.getAddr());
        clgModel.setContact(clgDto.getContact());
        boolean flag=clgDao.insertClgDao(clgModel);

        return flag;
    }

    @Override
    public List getClgRecordService() {
        List list=clgDao.getClgRecordDao();
        return list;
    }

    @Override
    public ClgResDto editClgService(Integer clgId) {
        ClgResDto clgResDto=clgDao.editCalDao(clgId);
        return clgResDto;
    }

    @Override
    public Boolean deleteClgService(Integer clgId) {
        Boolean flag=clgDao.deleteClgDao(clgId);
        return flag;
    }


}
