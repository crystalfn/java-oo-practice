package com.twu.role;

import com.twu.enumeration.TipsEnum;
import com.twu.hotSearch.HotSearchLibrary;
import java.util.Scanner;

public interface Role {
    Scanner scanner = new Scanner(System.in);

    default void returnToChooseOperationType() {
        operationAuthority();
        int chooseOperationType;
        try {
            chooseOperationType = scanner.nextInt();
            chooseOperation(chooseOperationType);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    default void viewHotSearch() {
        System.out.println(HotSearchLibrary.viewHotSearch());
        returnToChooseOperationType();
    };

    default void addHotSearch() {
        System.out.println(TipsEnum.INPUT_HOT_SEARCH_NAME);
        String hotSearch;
        try {
            hotSearch = scanner.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        HotSearchLibrary.addHotSearch(hotSearch, false);
        returnToChooseOperationType();
    };

    void operationAuthority();
    void chooseOperation(int chooseOperationType);
}
