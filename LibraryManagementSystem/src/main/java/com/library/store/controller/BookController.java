package com.library.store.controller;



import com.library.store.dto.LibraryResponseVO;
import com.library.store.model.BookModel;
import com.library.store.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "addbook")
    public Boolean insertBookController(@RequestBody BookModel bookModel){
       Boolean flag=bookService.insertBookService(bookModel);
        if (flag == true){
            return flag;
        }
        else {
            return flag;
        }
    }

    @PostMapping(value = "bookname")
    public LibraryResponseVO<List> getBookNameCtr(@RequestBody BookModel bookModel){
        LibraryResponseVO<List> libraryResponseVO=new LibraryResponseVO<>();
        List list=bookService.getBookNameService(bookModel);
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

    @GetMapping(value = "getbook")
    public LibraryResponseVO<List> getBookCtrl(){
        LibraryResponseVO<List> libraryResponseVO=new LibraryResponseVO<>();
        List list=bookService.getBookService();
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

    @GetMapping(value = "deletebook/{bid}")
    public Boolean deleteBookCtrl(@PathVariable Integer bid){
        Boolean flag=bookService.deleteBookService(bid);
        if (flag==true){
            return true;
        }
        else {
            return false;
        }
    }

}
