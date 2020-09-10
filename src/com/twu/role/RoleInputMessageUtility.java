package com.twu.role;

import com.twu.enumeration.TipsEnum;
import com.twu.hotSearch.HotSearchLibrary;

import java.util.Scanner;

class RoleInputMessageUtility {
    static Scanner scanner = new Scanner(System.in);

    static String getInputMessage(TipsEnum tipsMessage) {
        System.out.println(tipsMessage);
        String inputMessage;
        try {
            inputMessage = scanner.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return inputMessage;
    }

    static boolean isValidHotSearchName(String hotSearchName) {
        return HotSearchLibrary.hotSearchList
            .stream()
            .anyMatch(hotSearch -> hotSearchName.equals(hotSearch.getDescription()));
    }

    static boolean isValidRankOfHotSearch(int buyRankOfHotSearch) {
        return HotSearchLibrary.hotSearchList.size() >= buyRankOfHotSearch;
    }
}
