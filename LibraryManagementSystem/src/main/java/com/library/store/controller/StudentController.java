package com.library.store.controller;


import com.library.store.dto.LibraryResponseVO;
import com.library.store.dto.Libstuddto;
import com.library.store.model.StudentModel;
import com.library.store.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "addstudent")
    public Boolean insertStudentController(@RequestBody Libstuddto libstuddto){
        Boolean flag=studentService.insertStudentService(libstuddto);
        if (flag == true){
            return flag;
        }
        else {
            return flag;
        }
    }

    @PostMapping(value = "studentname")
    public LibraryResponseVO<List> getStudentNameCtr(@RequestBody StudentModel studentModel){
        LibraryResponseVO<List> libraryResponseVO=new LibraryResponseVO<>();
        List list=studentService.getStudentNameService(studentModel);
        if (list.size()!=0){
            libraryResponseVO.setResult(list);
            libraryResponseVO.setMessage("Data found");
            return libraryResponseVO;
        }
        else {
            libraryResponseVO.setMessage("Not found");
            return libraryResponseVO;
        }
    }

    @GetMapping(value = "getstudent")
    public LibraryResponseVO<List> getStudCtrl(){
        LibraryResponseVO<List> libraryResponseVO=new LibraryResponseVO<>();
        List list=studentService.getStudentService();
        if (list.size()!=0){
            libraryResponseVO.setResult(list);
            libraryResponseVO.setMessage("Data found");
            return libraryResponseVO;
        }
        else {
            libraryResponseVO.setMessage("Data not found");
            return libraryResponseVO;
        }
    }

    @GetMapping(value = "deletestudent/{sid}")
    public Boolean deleteStudentCtrl(@PathVariable Integer sid){
        Boolean flag=studentService.deletStudentService(sid);
        if (flag==true){
            return true;
        }
        else {
            return false;
        }
    }

}
