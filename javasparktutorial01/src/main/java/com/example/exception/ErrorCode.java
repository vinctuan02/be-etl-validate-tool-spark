package com.example.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "UNCATEGORIZED_EXCEPTION"),
    INPUT_INVALID(1001, "INPUT_INVALID"),
    INVALID_KEY(1002, "INVALID_KEY"),
    RECORD_NOT_FOUND(1003, "RECORD_NOT_FOUND"),
    RECORD_EXISTED(1004, "RECORD_EXISTED")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
