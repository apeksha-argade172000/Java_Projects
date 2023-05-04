package com.library.store.dto;


import com.library.store.model.BookModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {

    private Integer sid;
    private String sname;
    private String sbranch;
    private String saddress;
    private Long scontact;
    private String semail;

}
