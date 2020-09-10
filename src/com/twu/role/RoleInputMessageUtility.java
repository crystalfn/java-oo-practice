package com.twu.role;

import java.util.Scanner;

class RoleInputMessageUtility {
    static Scanner scanner = new Scanner(System.in);

    static String getInputMessage() {
        String inputMessage;
        try {
            inputMessage = scanner.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return inputMessage;
    }
}
