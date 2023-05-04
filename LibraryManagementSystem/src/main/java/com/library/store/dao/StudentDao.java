package com.library.store.dao;


import com.library.store.model.BookModel;
import com.library.store.model.StudentModel;

import java.awt.print.Book;
import java.util.List;

public interface StudentDao {

    Boolean insertStudData(StudentModel studentModel, BookModel bookModel);

    List getStudDao();

    Boolean deleteStudDao(Integer sid);

    List studentNameDao(StudentModel studentModel);
}


