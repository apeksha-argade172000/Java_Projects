package com.library.store.service;

import com.library.store.dto.BookDto;
import com.library.store.model.BookModel;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    Boolean insertBookService(BookModel bookModel);

    List getBookService();



    Boolean deleteBookService(Integer bid);

    List getBookNameService(BookModel bookModel);
}
