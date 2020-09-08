package com.twu.role;

import com.twu.enumeration.OperationTypeEnum;
import com.twu.enumeration.TipsEnum;

public class Administrator implements Role {
    private final String name;

    public Administrator(String name) {
        this.name = name;
    }

    @Override
    public void operationAuthority() {
        System.out.println("你好，" + name + "，你可以" + "\n"
            + "1." + OperationTypeEnum.VIEW_HOT_SEARCH + "\n"
            + "2." + OperationTypeEnum.ADD_HOT_SEARCH + "\n"
            + "3." + OperationTypeEnum.ADD_SUPPER_HOT_SEARCH + "\n"
            + "4.退出");
    }

    @Override
    public void chooseOperation(int chooseOperationType) {
        switch (chooseOperationType) {
            case 1:
                viewHotSearch();
                break;
            case 2:
                addHotSearch();
                break;
            case 3:
                addSuperHotSearch();
                break;
            case 4:
                System.out.println(TipsEnum.EXIT);
                break;
            default:
                System.out.println(TipsEnum.OPERATION_TYPE_WRONG);
                break;
        }
    }

    private void addSuperHotSearch() {
    }
}
