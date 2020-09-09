package com.twu.role;

import com.twu.enumeration.OperationTypeEnum;
import com.twu.enumeration.TipsEnum;
import com.twu.hotSearch.HotSearch;
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
        String hotSearchName;
        try {
            hotSearchName = scanner.next();
            if (isValidHotSearchName(hotSearchName)) {
                voteForValidHotSearch(hotSearchName);
            } else {
                System.out.println(TipsEnum.INVALID_VOTE_HOT_SEARCH_NAME);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        returnToChooseOperationType();
    }

    private boolean isValidHotSearchName(String hotSearchName) {
        return HotSearchLibrary.hotSearchList
            .stream()
            .anyMatch(hotSearch -> hotSearchName.equals(hotSearch.getDescription()));
    }

    private void voteForValidHotSearch(String hotSearchName) {
        int voteHotSearchValue;
        voteHotSearchValue = getVoteValue();
        if (voteHotSearchValue > poll) {
            System.out.println(TipsEnum.VOTE_FAIL);
        } else {
            poll -= voteHotSearchValue;
            updateHotSearchHotValue(hotSearchName, voteHotSearchValue);
            System.out.println(TipsEnum.VOTE_SUCCESS);
        }
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
                int voteValue = hotSearch.getIsSuper() ? voteHotSearchValue * 2 : voteHotSearchValue;
                hotSearch.setHotValue(hotSearch.getHotValue() + voteValue);
            }
        });
    }

    private void buyHotSearch() {
        String buyHotSearchName = getBuyHotSearchName();
        if (!isValidHotSearchName(buyHotSearchName)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_SEARCH_NAME);
            System.out.println(TipsEnum.BUY_FAIL);
            returnToChooseOperationType();
            return;
        }

        int buyRankOfHotSearch = getBuyRankOfHotSearch();
        if (!isValidRankOfHotSearch(buyRankOfHotSearch)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_VALUE);
            System.out.println(TipsEnum.BUY_FAIL);
            returnToChooseOperationType();
            return;
        }

        int priceForBuyHotSearch = getPriceForBuyHotSearch();
        if (priceForBuyHotSearch == -1) {
            System.out.println(TipsEnum.INVALID_INPUT_PRICE);
            System.out.println(TipsEnum.BUY_FAIL);
            returnToChooseOperationType();
            return;
        }

        if (isFirstBuyer(buyRankOfHotSearch)) {
            firstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
            System.out.println(TipsEnum.BUY_SUCCESS);
        } else {
            if (!isValidPriceForBuyHotSearch(buyRankOfHotSearch, priceForBuyHotSearch)) {
                System.out.println(TipsEnum.INVALID_BUY_HOT_SEARCH_PRICE);
                System.out.println(TipsEnum.BUY_FAIL);
                return;
            } else {
                notFirstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
                System.out.println(TipsEnum.BUY_SUCCESS);
            }
        }
        returnToChooseOperationType();
    }

    private String getBuyHotSearchName() {
        System.out.println(TipsEnum.INPUT_BUY_HOT_SEARCH_NAME);
        String buyHotSearchName;
        try {
            buyHotSearchName = scanner.next().trim();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return buyHotSearchName;
    }

    private int getBuyRankOfHotSearch() {
        System.out.println(TipsEnum.INPUT_BUY_HOT_VALUE);
        int buyRankOfHotSearch;
        try {
            buyRankOfHotSearch = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return buyRankOfHotSearch;
    }

    private boolean isValidRankOfHotSearch(int buyRankOfHotSearch) {
        return HotSearchLibrary.hotSearchList.size() >= buyRankOfHotSearch;
    }

    private int getPriceForBuyHotSearch() {
        System.out.println(TipsEnum.INPUT_BUY_HOT_SEARCH_PRICE);
        String priceForBuyHotSearch;
        try {
            priceForBuyHotSearch = scanner.next();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        if (!priceForBuyHotSearch.matches("^[1-9][0-9]*")) {
            return -1;
        }
        return Integer.parseInt(priceForBuyHotSearch);
    }

    private boolean isFirstBuyer(int buyRankOfHotSearch) {
        for (HotSearch hotSearch : HotSearchLibrary.hotSearchList) {
            if (hotSearch.getRank() == buyRankOfHotSearch) {
                return false;
            }
        }
        return true;
    }

    private void firstBuyValidHotSearch(String buyHotSearchName, int buyRankOfHotSearch, int priceForBuyHotSearch) {
        HotSearchLibrary.hotSearchList.forEach(hotSearch -> {
            if (buyHotSearchName.equalsIgnoreCase(hotSearch.getDescription())) {
                hotSearch.setRank(buyRankOfHotSearch);
                hotSearch.setCurrentPurchasingPrice(priceForBuyHotSearch);

            }
        });
    }

    private boolean isValidPriceForBuyHotSearch(int buyRankOfHotSearch, int priceForBuyHotSearch) {
        for (HotSearch hotSearch : HotSearchLibrary.hotSearchList) {
            if (hotSearch.getRank() == buyRankOfHotSearch) {
                return hotSearch.getCurrentPurchasingPrice() < priceForBuyHotSearch;
            }
        }
        return false;
    }

    private void notFirstBuyValidHotSearch(String buyHotSearchName, int buyRankOfHotSearch, int priceForBuyHotSearch) {
        HotSearch removeHotSearch = HotSearchLibrary.hotSearchList.get(0);
        for (HotSearch hotSearch : HotSearchLibrary.hotSearchList) {
            if (hotSearch.getRank() == buyRankOfHotSearch) {
                removeHotSearch = hotSearch;
                break;
            }
        }
        HotSearchLibrary.hotSearchList.remove(removeHotSearch);
        firstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
    }
}
