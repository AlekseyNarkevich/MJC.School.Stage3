package com.epam.esm.exception;

import lombok.Data;

@Data
public class ExceptionEntity {

    private String errorMessage;
    private Integer errorCode;

}
