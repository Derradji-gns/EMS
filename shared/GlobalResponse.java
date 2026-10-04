package com.derradjiamine.Backend.shared;

import lombok.Setter;

import java.util.List;

@Setter
public class GlobalResponse<T> {
    public final static String SUCCESS = "SUCCESS";
    public final static String ERROR = "ERROR";


    private final String Status;
    private final T data;
    private final List<ErrorItem> errors;

    public GlobalResponse(List<ErrorItem> errors) {
        this.Status = ERROR;
        this.data = null;
        this.errors = errors;
    }

    public GlobalResponse(T data) {
        this.Status = SUCCESS;
        this.data = data;
        this.errors = null;
    }

    public record ErrorItem(String message) {
    }
}
