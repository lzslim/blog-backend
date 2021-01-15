package com.example.demo.common;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class CommonResult<T>{
    private boolean success;
    private T data;
    private String message;

    private CommonResult(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> ResponseEntity<CommonResult<T>> success(T data, String message) {
        return new ResponseEntity<CommonResult<T>>(new CommonResult<T>(true, data, message), HttpStatus.OK);
    }

    public static <T> ResponseEntity<CommonResult<T>> fail(T data, String message) {
        return new ResponseEntity<CommonResult<T>>(new CommonResult<T>(false, data, message), HttpStatus.BAD_REQUEST);
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
