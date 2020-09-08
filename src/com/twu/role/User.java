package com.twu.role;

import com.twu.enumeration.OperationTypeEnum;

public class User implements Role {
    private final String name;
    private final int poll = 10;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void operationAuthority() {
        System.out.println("你好，" + name + "，你可以" + "\n"
            + "1." + OperationTypeEnum.VIEW_HOT_SEARCH + "\n"
            + "2." + OperationTypeEnum.VOTE_FOR_HOT_SEARCH + "\n"
            + "3." + OperationTypeEnum.ADD_HOT_SEARCH + "\n"
            + "4." + OperationTypeEnum.BUY_HOT_SEARCH + "\n"
            + "5.退出");
    }

    @Override
    public void chooseOperation(int chooseOperationType) {

    }
}
