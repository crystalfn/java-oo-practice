package com.twu.role;

import com.twu.InputMessageUtility;
import com.twu.enumeration.TipsEnum;
import com.twu.hotSearch.HotSearchLibrary;

public interface Role {
    default void returnToChooseOperationType() {
        operationAuthority();
        int chooseOperationType = Integer.parseInt(InputMessageUtility.getInputMessage());
        chooseOperation(chooseOperationType);
    }

    default void viewHotSearch() {
        System.out.println(HotSearchLibrary.viewHotSearch());
        returnToChooseOperationType();
    };

    default void addHotSearch() {
        System.out.println(TipsEnum.INPUT_HOT_SEARCH_NAME);
        String hotSearch = InputMessageUtility.getInputMessage();
        HotSearchLibrary.addHotSearch(hotSearch);
        returnToChooseOperationType();
    };

    void operationAuthority();
    void chooseOperation(int chooseOperationType);
}
