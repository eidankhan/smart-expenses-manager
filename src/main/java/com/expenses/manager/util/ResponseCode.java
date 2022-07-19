package com.expenses.manager.util;

public enum ResponseCode {
    SUCCESS("EXPENSE-MANAGER-200", "Success"),
    NO_CONTENT("EXPENSE-MANAGER-201", "Collection is empty");

    private String code;
    private String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
