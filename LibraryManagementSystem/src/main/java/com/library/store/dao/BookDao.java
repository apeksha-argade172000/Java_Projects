package com.library.store.dao;

import com.library.store.model.BookModel;

import java.util.List;

public interface BookDao {
    Boolean insertBookData(BookModel bookModel);

    List getBookDao();

    Boolean deleteBookDao(Integer bid);

    List bookNameDao(BookModel bookModel);
}
