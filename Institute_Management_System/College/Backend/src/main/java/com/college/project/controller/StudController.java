package com.college.project.controller;

import com.college.project.dto.ResponseVO;
import com.college.project.dto.StudDto;
import com.college.project.dto.StudResDto;
import com.college.project.dto.StudResponseVO;
import com.college.project.service.Studservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudController {
    @Autowired
    private Studservice studservice;

    @RequestMapping(value = "stud", method = RequestMethod.POST)
    public Boolean insertStudController(@RequestBody StudDto studDto) {
        boolean flag = studservice.insertStudService(studDto);
        if (flag) {
            return flag;
        } else {
            return flag;
        }


    }
    @RequestMapping(value = "stud", method = RequestMethod.GET)
    public StudResponseVO<List> getStudController(){
        StudResponseVO<List> studResponseVO=new StudResponseVO<>();
        List list=studservice.getStudService();
        if (list.size()!=0)
        {
            studResponseVO.setResult(list);
            studResponseVO.setMessage("Data Found");
            return studResponseVO;
        }
        else
        {
            studResponseVO.setMessage("Data not found");
            return studResponseVO;

        }
    }

    @RequestMapping(value = "stud/{studid}",method = RequestMethod.GET)
    public StudResponseVO<StudResDto> editStudCtrl(@PathVariable Integer studid){
        StudResponseVO<StudResDto> studResponseVO=new StudResponseVO<>();
        StudResDto studResDto=studservice.editStudService(studid);
        if (studResDto!=null)
        {
            studResponseVO.setMessage("Data Found");
            studResponseVO.setResult(studResDto);
            return  studResponseVO;
        }
        else {
            studResponseVO.setMessage("Data not found");
            return studResponseVO;
        }
    }
    @RequestMapping(value = "studlist/{id}",method = RequestMethod.GET)
    public StudResponseVO<List> getStudListCtrl(@PathVariable Integer id){
        StudResponseVO<List> studResponseVO=new StudResponseVO<>();
        List list=studservice.getStudListService(id);
        if (list.size()!=0)
        {
            studResponseVO.setMessage("Data Found");
            studResponseVO.setResult(list);
            return studResponseVO;
        }
        else {
            studResponseVO.setMessage("Not Found");
            return studResponseVO;
        }
    }

    @RequestMapping(value = "studlistnew/{clgId}",method = RequestMethod.GET)
    public StudResponseVO<List> getNewStudListCtrl(@PathVariable Integer clgId){
        StudResponseVO<List> studResponseVO=new StudResponseVO<>();
        List list=studservice.getNewStudListService(clgId);
        if (list.size()!=0)
        {
            studResponseVO.setMessage("Data Found");
            studResponseVO.setResult(list);
            return studResponseVO;
        }
        else {
            studResponseVO.setMessage("Not Found");
            return studResponseVO;
        }
    }

    @RequestMapping(value = "deletestud/{studid}",method = RequestMethod.GET)
    public ResponseVO<Boolean> deleteClgCtrl(@PathVariable Integer studid){
        System.out.println("===>"+studid);
        ResponseVO<Boolean>  responseVO=new ResponseVO<>();
        Boolean flag=studservice.deleteStudService(studid);
        if (flag==true)
        {

            responseVO.setMessage("Data Found");
            return responseVO;
        }
        else
        {
            responseVO.setMessage("Message not found");
            return responseVO;
        }
    }
}