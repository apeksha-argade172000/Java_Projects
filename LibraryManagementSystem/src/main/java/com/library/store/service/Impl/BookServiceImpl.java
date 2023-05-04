package com.library.store.service.Impl;

import com.library.store.dao.BookDao;
import com.library.store.dao.StudentDao;
import com.library.store.model.BookModel;
import com.library.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean insertBookService(BookModel bookModel) {
        Boolean flag=bookDao.insertBookData(bookModel);
        System.out.println("===>"+bookModel.getBname());
        return flag;
    }

    @Override
    public List getBookService() {
        List list=bookDao.getBookDao();
        return list;
    }

    @Override
    public Boolean deleteBookService(Integer bid) {
        Boolean flag=bookDao.deleteBookDao(bid);
        return flag;
    }

    @Override
    public List getBookNameService(BookModel bookModel) {
        List list=bookDao.bookNameDao(bookModel);
        return list;
    }
}
