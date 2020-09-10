package com.twu;

import com.twu.enumeration.OperationTypeEnum;
import com.twu.enumeration.TipsEnum;
import com.twu.enumeration.UserTypeEnum;
import com.twu.role.Administrator;
import com.twu.role.Role;
import com.twu.role.User;

public class Main {
    public static void main(String[] args) {
        int userType = getUserType();
        if (userType == 3) {
            System.out.println(TipsEnum.EXIT);
            return;
        }
        if (userType != 1 && userType != 2) {
            System.out.println(TipsEnum.USER_TYPE_WRONG);
            main(null);
        }

        String userName = getUserName();
        String password = getPassword();
        if (isValidRole(userType, userName, password)) {
            operateAccordingToRole(userType, userName);
        } else {
            System.out.println(TipsEnum.ERROR_ID);
        }

        main(null);
    }

    private static int getUserType() {
        System.out.println(TipsEnum.ASK_USERTYPE
            + "1." + UserTypeEnum.USER
            + "2." + UserTypeEnum.ADMINISTRATOR
            + "3." + OperationTypeEnum.EXIT);

        return Integer.parseInt(InputMessageUtility.getInputMessage());
    }

    private static String getUserName() {
        System.out.println(TipsEnum.ASK_NICKNAME);
        return InputMessageUtility.getInputMessage();
    }

    private static String getPassword() {
        System.out.println(TipsEnum.ASK_PASSWORD);
        return InputMessageUtility.getInputMessage();
    }

    private static Boolean isValidRole(int userType, String userName, String password) {
        return (userType == 1 && password.equals(userName + "123"))
            || (userType == 2 && password.equals(userName + "123456"));
    }

    private static void operateAccordingToRole(int userType, String userName) {
        if (userType == 1) {
            Role user = new User(userName);
            operation(user);
        }
        if (userType == 2) {
            Role administrator = new Administrator(userName);
            operation(administrator);
        }
    }

    private static void operation(Role role) {
        role.operationAuthority();
        int chooseOperationType = Integer.parseInt(InputMessageUtility.getInputMessage());
        role.chooseOperation(chooseOperationType);
    }
}
