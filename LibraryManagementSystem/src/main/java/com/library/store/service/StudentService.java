package com.library.store.service;


import com.library.store.dto.Libstuddto;
import com.library.store.dto.StudentDto;
import com.library.store.model.StudentModel;

import java.util.List;

public interface StudentService {

    Boolean insertStudentService(Libstuddto libstuddto);

    List getStudentService();

    Boolean deletStudentService(Integer sid);

    List getStudentNameService(StudentModel studentModel);
}


