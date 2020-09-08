package com.twu;

import com.twu.enumeration.OperationTypeEnum;
import com.twu.enumeration.TipsEnum;
import com.twu.enumeration.UserTypeEnum;
import com.twu.role.Administrator;
import com.twu.role.Role;
import com.twu.role.User;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int userType = getUserType();
        if (userType == 3) {
            System.out.println(TipsEnum.EXIT);
            return;
        } else if (userType != 1 && userType != 2) {
            System.out.println(TipsEnum.USER_TYPE_WRONG);
            return;
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

        int userType;
        try {
            userType = SCANNER.nextInt();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return userType;
    }

    private static String getUserName() {
        System.out.println(TipsEnum.ASK_NICKNAME);
        String userName;
        try {
            userName = SCANNER.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return userName;
    }

    private static String getPassword() {
        System.out.println(TipsEnum.ASK_PASSWORD);
        String password;
        try {
            password = SCANNER.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return password;
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
        int chooseOperationType;
        try {
            chooseOperationType = SCANNER.nextInt();
            role.chooseOperation(chooseOperationType);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
