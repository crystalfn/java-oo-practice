package com.twu.hotSearch;

class BuyHotSearchUtility {
    static boolean isFirstBuyer(int buyRankOfHotSearch) {
        for (HotSearch hotSearch : HotSearchLibrary.hotSearchList) {
            if (hotSearch.getRank() == buyRankOfHotSearch) {
                return false;
            }
        }
        return true;
    }

    static void firstBuyValidHotSearch(String buyHotSearchName, int buyRankOfHotSearch, int priceForBuyHotSearch) {
        HotSearchLibrary.hotSearchList.forEach(hotSearch -> {
            if (buyHotSearchName.equalsIgnoreCase(hotSearch.getDescription())) {
                hotSearch.setRank(buyRankOfHotSearch);
                hotSearch.setCurrentPurchasingPrice(priceForBuyHotSearch);

            }
        });
    }

    static boolean isValidPriceForBuyHotSearch(int buyRankOfHotSearch, int priceForBuyHotSearch) {
        for (HotSearch hotSearch : HotSearchLibrary.hotSearchList) {
            if (hotSearch.getRank() == buyRankOfHotSearch) {
                return hotSearch.getCurrentPurchasingPrice() < priceForBuyHotSearch;
            }
        }
        return false;
    }

    static void notFirstBuyValidHotSearch(String buyHotSearchName, int buyRankOfHotSearch, int priceForBuyHotSearch) {
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
