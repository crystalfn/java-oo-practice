package com.twu;

import java.util.Scanner;

public class InputMessageUtility {
    static Scanner scanner = new Scanner(System.in);

    public static String getInputMessage() {
        String inputMessage;
        try {
            inputMessage = scanner.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return inputMessage;
    }
}
