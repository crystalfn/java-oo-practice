package com.twu.role;

import com.twu.enumeration.OperationTypeEnum;
import com.twu.enumeration.TipsEnum;
import com.twu.hotSearch.HotSearchLibrary;

public class User implements Role {
    private final String name;
    private int poll = 10;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void operationAuthority() {
        System.out.println("你好，" + name + "，你可以" + "\n"
            + "1." + OperationTypeEnum.VIEW_HOT_SEARCH
            + "2." + OperationTypeEnum.VOTE_FOR_HOT_SEARCH
            + "3." + OperationTypeEnum.ADD_HOT_SEARCH
            + "4." + OperationTypeEnum.BUY_HOT_SEARCH
            + "5." + OperationTypeEnum.EXIT);
    }

    @Override
    public void chooseOperation(int chooseOperationType) {
        switch (chooseOperationType) {
            case 1:
                viewHotSearch();
                break;
            case 2:
                voteForHotSearch();
                break;
            case 3:
                addHotSearch();
                break;
            case 4:
                buyHotSearch();
                break;
            case 5:
                System.out.println(TipsEnum.HOME);
                break;
            default:
                System.out.println(TipsEnum.OPERATION_TYPE_WRONG);
                break;
        }
    }

    private void voteForHotSearch() {
        System.out.println(TipsEnum.INPUT_VOTE_HOT_SEARCH_NAME);
        String hotSearchName = RoleInputMessageUtility.getInputMessage();

        System.out.println(TipsEnum.INPUT_VOTE_VALUE + "您目前还有" + poll + "票");
        int inputPoll = Integer.parseInt(RoleInputMessageUtility.getInputMessage());

        poll = HotSearchLibrary.voteForHotSearch(hotSearchName, poll, inputPoll);
        returnToChooseOperationType();
    }

    private void buyHotSearch() {
        System.out.println(TipsEnum.INPUT_BUY_HOT_SEARCH_NAME);
        String buyHotSearchName = RoleInputMessageUtility.getInputMessage();

        System.out.println(TipsEnum.INPUT_BUY_HOT_VALUE);
        int buyRankOfHotSearch = Integer.parseInt(RoleInputMessageUtility.getInputMessage());

        System.out.println(TipsEnum.INPUT_BUY_HOT_SEARCH_PRICE);
        String priceForBuyHotSearch = RoleInputMessageUtility.getInputMessage();

        HotSearchLibrary.buyHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
        returnToChooseOperationType();
    }
}
