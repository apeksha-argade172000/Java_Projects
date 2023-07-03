package com.college.project.controller;

import com.college.project.dto.ClgDto;
import com.college.project.dto.ClgResDto;
import com.college.project.dto.ResponseVO;
import com.college.project.service.ClgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClgController {
    @Autowired
    private ClgService clgService;

    @RequestMapping(value = "clg",method = RequestMethod.POST)
    public boolean insertClgCtrl(@RequestBody ClgDto clgDto)
    {
        boolean flag=clgService.insertClgService(clgDto);
        if (flag){
            return flag;
        }
        else {
            return flag;
        }
    }
    @RequestMapping(value = "clg",method = RequestMethod.GET)
    public ResponseVO<List> getClgRecordCtrl(){
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=clgService.getClgRecordService();
        if(list.size()!=0)
        {
            responseVO.setResult(list);
            responseVO.setMessage("Data Found");
            return responseVO;
        }
        else {
            responseVO.setMessage("Data Not Found");
            return responseVO;
        }
    }
    @RequestMapping(value = "clg/{clgId}",method = RequestMethod.GET)
    public ResponseVO<ClgResDto> editClgCtrl(@PathVariable Integer clgId){
        ResponseVO<ClgResDto>  responseVO=new ResponseVO<>();
        ClgResDto clgResDto=clgService.editClgService(clgId);
        if (clgResDto!=null)
        {
            responseVO.setResult(clgResDto);
            responseVO.setMessage("Data Found");
            return responseVO;
        }
        else
        {
            responseVO.setMessage("Message not found");
            return responseVO;
        }
    }
    @RequestMapping(value = "deleteclg/{clgId}",method = RequestMethod.GET)
    public ResponseVO<Boolean> deleteClgCtrl(@PathVariable Integer clgId){
        ResponseVO<Boolean>  responseVO=new ResponseVO<>();
        Boolean flag=clgService.deleteClgService(clgId);
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
