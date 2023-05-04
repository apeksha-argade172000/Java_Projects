package com.library.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryResponseVO<T>{
    private String statuscode;
    private String message;
    private T result;
}
