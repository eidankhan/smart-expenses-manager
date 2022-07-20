package com.expenses.manager.util;

public enum ResponseCode {
    SUCCESS("EXPENSE-MANAGER-200", "Success"),
    NO_CONTENT("EXPENSE-MANAGER-201", "Collection is empty"),
    INVALID_DATA("EXPENSE-MANAGER-202", "Unable to add data"),
    NOT_FOUND("EXPENSE-MANAGER-404", "No data found");

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
