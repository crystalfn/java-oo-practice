package com.twu.enumeration;

public enum UserTypeEnum {
    ADMINISTRATOR("管理员\n"),
    USER("用户\n");

    private final String value;
    UserTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
