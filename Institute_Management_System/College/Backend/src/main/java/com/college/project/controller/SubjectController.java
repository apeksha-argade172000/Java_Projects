package com.college.project.controller;

import com.college.project.dto.ResponseVO;
import com.college.project.dto.StudResponseVO;
import com.college.project.dto.SubjectDto;
import com.college.project.dto.SubjectResDto;
import com.college.project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SubjectController {
    @Autowired
    private SubjectService  subjectService;

    @RequestMapping(value = "sub",method = RequestMethod.POST)
    public boolean insertSubController(@RequestBody SubjectDto subjectDto){
        Boolean flag=subjectService.insertSubService( subjectDto);
        if (flag)
        {
            return flag;
        }
        else {
            return flag;
        }
    }

    @RequestMapping(value = "getsub", method = RequestMethod.GET)
    public StudResponseVO<List> getSubController(){
        StudResponseVO<List> studResponseVO=new StudResponseVO<>();
        List list=subjectService.getSubService();
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


    @RequestMapping(value = "subbyclg/{clgId}",method = RequestMethod.GET)
    public StudResponseVO<List> getSubjectController(@PathVariable Integer clgId){
        StudResponseVO<List> studResponseVO=new StudResponseVO<>();
        List list=subjectService.getSubjectService(clgId);
        if (list.size()!=0)
        {
            studResponseVO.setMessage("Data Found");
            studResponseVO.setResult(list);
            return studResponseVO;
        }
        else {
            studResponseVO.setMessage("Data not found");
            return studResponseVO;
        }
    }

    @RequestMapping(value = "sub/{subid}",method = RequestMethod.GET)
    public StudResponseVO<SubjectResDto> editSubjectController(@PathVariable Integer subid){
        StudResponseVO<SubjectResDto> studResponseVO=new StudResponseVO<>();
        SubjectResDto subjectResDto=subjectService.editSubService(subid);
        if (subjectResDto!=null)
        {
            studResponseVO.setMessage("Data found");
            studResponseVO.setResult(subjectResDto);
            return studResponseVO;
        }
        else {
            studResponseVO.setMessage("Data not found");

            return studResponseVO;
        }
    }

    @RequestMapping(value = "deletesub/{subid}",method = RequestMethod.GET)
    public ResponseVO<Boolean> deleteSubCtrl(@PathVariable Integer subid){
        ResponseVO<Boolean>  responseVO=new ResponseVO<>();
        Boolean flag=subjectService.deleteSubService(subid);
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
