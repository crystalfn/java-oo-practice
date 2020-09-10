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

    public static void voteForHotSearch(String hotSearchName, int poll) {
        if (VoteForHotSearchUtility.isValidHotSearchName(hotSearchName)) {
            VoteForHotSearchUtility.voteForValidHotSearch(hotSearchName, poll);
        } else {
            System.out.println(TipsEnum.INVALID_VOTE_HOT_SEARCH_NAME);
        }
    }

    public static void buyHotSearch(String buyHotSearchName, int buyRankOfHotSearch, int priceForBuyHotSearch) {
        if (BuyHotSearchUtility.isFirstBuyer(buyRankOfHotSearch)) {
            BuyHotSearchUtility.firstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
            System.out.println(TipsEnum.BUY_SUCCESS);
            return;
        }

        if (!BuyHotSearchUtility.isValidPriceForBuyHotSearch(buyRankOfHotSearch, priceForBuyHotSearch)) {
            System.out.println(TipsEnum.INVALID_BUY_HOT_SEARCH_PRICE);
            System.out.println(TipsEnum.BUY_FAIL);
        } else {
            BuyHotSearchUtility.notFirstBuyValidHotSearch(buyHotSearchName, buyRankOfHotSearch, priceForBuyHotSearch);
            System.out.println(TipsEnum.BUY_SUCCESS);
        }
    }
}
