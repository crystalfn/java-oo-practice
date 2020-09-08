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
            + "1." + OperationTypeEnum.VIEW_HOT_SEARCH + "\n"
            + "2." + OperationTypeEnum.VOTE_FOR_HOT_SEARCH + "\n"
            + "3." + OperationTypeEnum.ADD_HOT_SEARCH + "\n"
            + "4." + OperationTypeEnum.BUY_HOT_SEARCH + "\n"
            + "5.退出");
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
                System.out.println(TipsEnum.EXIT);
                break;
            default:
                System.out.println(TipsEnum.OPERATION_TYPE_WRONG);
                break;
        }
    }

    private void voteForHotSearch() {
        System.out.println(TipsEnum.INPUT_VOTE_HOT_SEARCH_NAME);
        String hotSearchName;
        int voteHotSearchValue;
        try {
            hotSearchName = scanner.next();
            voteHotSearchValue = getVoteValue();
            if (voteHotSearchValue > poll) {
                System.out.println(TipsEnum.VOTE_FAIL);
            } else {
                poll -= voteHotSearchValue;
                updateHotSearchHotValue(hotSearchName, voteHotSearchValue);
                System.out.println(TipsEnum.VOTE_SUCCESS);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        returnToChooseOperationType();
    }

    private int getVoteValue() {
        System.out.println(TipsEnum.INPUT_VOTE_VALUE + "您目前还有" + poll + "票");
        int voteHotSearchValue;
        try {
            voteHotSearchValue = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return voteHotSearchValue;
    }

    private void updateHotSearchHotValue(String hotSearchName, int voteHotSearchValue) {
        HotSearchLibrary.hotSearchList.forEach(hotSearch -> {
            if (hotSearch.getDescription().equals(hotSearchName)) {
                hotSearch.setHotValue(hotSearch.getHotValue() + voteHotSearchValue);
            }
        });
    }

    private void buyHotSearch() {
    }
}
