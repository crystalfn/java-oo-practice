package com.twu.hotSearch;

import com.twu.enumeration.TipsEnum;
import java.util.ArrayList;
import java.util.List;

public class HotSearchLibrary {
    public static final List<HotSearch> hotSearchList = new ArrayList<>();

    public static String viewHotSearch() {
        List<HotSearch> buyHotSearchList = ViewHotSearchUtility.getBuyHotSearchList();
        List<HotSearch> commonHotSearchList = ViewHotSearchUtility.getCommonHotSearchList();
        StringBuilder hotSearches = ViewHotSearchUtility.getHotSearches(buyHotSearchList, commonHotSearchList);
        return hotSearches.toString();
    }

    public static void addHotSearch(String hotSearch) {
        HotSearch addHotSearch = new HotSearch(hotSearch, false);
        if (AddHotSearchUtility.isNewHotSearch(hotSearch)) {
            hotSearchList.add(addHotSearch);
            System.out.println(TipsEnum.ADD_HOT_SEARCH_SUCCESS);
        } else {
            System.out.println(TipsEnum.ADD_HOT_SEARCH_FAIL);
        }
    }

    public static void addSuperHotSearch(String hotSearch) {
        HotSearch addHotSearch = new HotSearch(hotSearch, true);
        if (AddHotSearchUtility.isNewHotSearch(hotSearch)) {
            hotSearchList.add(addHotSearch);
            System.out.println(TipsEnum.ADD_SUPER_HOT_SEARCH_SUCCESS);
        } else {
            System.out.println(TipsEnum.ADD_SUPER_HOT_SEARCH_FAIL);
        }
    }

    public static int voteForHotSearch(String hotSearchName, int poll, int inputPoll) {
        if (!VoteForHotSearchUtility.isValidHotSearchName(hotSearchName)) {
            System.out.println(TipsEnum.INVALID_VOTE_HOT_SEARCH_NAME);
            System.out.println(TipsEnum.VOTE_FAIL);
            return poll;
        }

        if (inputPoll > poll) {
            System.out.println(TipsEnum.INVALID_VOTE_HOT_VALUE);
            System.out.println(TipsEnum.VOTE_FAIL);
            return poll;
        }

        int currentPoll = VoteForHotSearchUtility.updateHotSearchHotValue(hotSearchName, poll, inputPoll);
        System.out.println(TipsEnum.VOTE_SUCCESS);
        return currentPoll;
    }

    public static void buyHotSearch(String buyHotSearchName, int buyRankOfHotSearch, String priceForBuyHotSearch) {
        if (!BuyHotSearchUtility.isValidHotSearchName(buyHotSearchName)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_SEARCH_NAME);
            System.out.println(TipsEnum.BUY_FAIL);
            return;
        }

        if (!BuyHotSearchUtility.isValidRankOfHotSearch(buyRankOfHotSearch)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_VALUE);
            System.out.println(TipsEnum.BUY_FAIL);
            return;
        }

        if (!BuyHotSearchUtility.isEnoughPriceForBuyHotSearch(priceForBuyHotSearch)) {
            System.out.println(TipsEnum.INVALID_INPUT_PRICE);
            System.out.println(TipsEnum.BUY_FAIL);
            return;
        }

        int inputPrice = Integer.parseInt(priceForBuyHotSearch);
        if (BuyHotSearchUtility.isFirstBuyer(buyRankOfHotSearch)) {
            BuyHotSearchUtility.firstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, inputPrice);
            System.out.println(TipsEnum.BUY_SUCCESS);
            return;
        }

        if (!BuyHotSearchUtility.isEnoughPriceForBuyHotSearch(buyRankOfHotSearch, inputPrice)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_SEARCH_PRICE);
            System.out.println(TipsEnum.BUY_FAIL);
            return;
        }

        BuyHotSearchUtility.notFirstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, inputPrice);
        System.out.println(TipsEnum.BUY_SUCCESS);
    }
}
