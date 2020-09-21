package com.cg.movieticketsystem.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private String message;
    private List<String> details = new ArrayList<>();

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }
}
