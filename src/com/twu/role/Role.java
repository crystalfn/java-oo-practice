package com.twu.role;

public interface Role {
    default void viewHotSearch() {

    };

    default void addHotSearch() {

    };

    void operationAuthority();
    void chooseOperation(int chooseOperationType);
}
