package com.twu.enumeration;

public enum UserTypeEnum {
    ADMINISTRATOR("管理员"),
    USER("用户");

    private final String value;
    UserTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
