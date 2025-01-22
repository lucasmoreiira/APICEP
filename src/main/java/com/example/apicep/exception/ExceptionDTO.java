package com.example.apicep.exception;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details of error response")
public class ExceptionDTO {

    private String message;
    private Integer status;

    public ExceptionDTO(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
