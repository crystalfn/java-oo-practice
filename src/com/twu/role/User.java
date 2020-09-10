package com.twu.role;

import com.twu.enumeration.OperationTypeEnum;
import com.twu.enumeration.TipsEnum;
import com.twu.hotSearch.HotSearchLibrary;
import com.twu.hotSearch.VoteForHotSearchUtility;

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
        String hotSearchName;
        try {
            hotSearchName = scanner.next();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        HotSearchLibrary.voteForHotSearch(hotSearchName, poll);
        poll = VoteForHotSearchUtility.getCurrentPoll();
        returnToChooseOperationType();
    }

    private void buyHotSearch() {
        String buyHotSearchName = RoleInputMessageUtility.getInputMessage(TipsEnum.INPUT_BUY_HOT_SEARCH_NAME);
        if (!RoleInputMessageUtility.isValidHotSearchName(buyHotSearchName)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_SEARCH_NAME);
            System.out.println(TipsEnum.BUY_FAIL);
            returnToChooseOperationType();
            return;
        }

        int buyRankOfHotSearch = Integer.parseInt(RoleInputMessageUtility.getInputMessage(TipsEnum.INPUT_BUY_HOT_VALUE));
        if (!RoleInputMessageUtility.isValidRankOfHotSearch(buyRankOfHotSearch)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_VALUE);
            System.out.println(TipsEnum.BUY_FAIL);
            returnToChooseOperationType();
            return;
        }

        int priceForBuyHotSearch = Integer.parseInt(RoleInputMessageUtility.getInputMessage(TipsEnum.INPUT_BUY_HOT_SEARCH_PRICE));
        if (priceForBuyHotSearch == -1) {
            System.out.println(TipsEnum.INVALID_INPUT_PRICE);
            System.out.println(TipsEnum.BUY_FAIL);
            returnToChooseOperationType();
            return;
        }

        HotSearchLibrary.buyHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
        returnToChooseOperationType();
    }
}
