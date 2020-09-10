package com.twu.hotSearch;

class BuyHotSearchUtility {
    static boolean isValidHotSearchName(String hotSearchName) {
        return HotSearchLibrary.hotSearchList
            .stream()
            .anyMatch(hotSearch -> hotSearchName.equals(hotSearch.getDescription()));
    }

    static boolean isValidRankOfHotSearch(int buyRankOfHotSearch) {
        return HotSearchLibrary.hotSearchList.size() >= buyRankOfHotSearch;
    }

    static boolean isEnoughPriceForBuyHotSearch(String priceForBuyHotSearch) {
        return priceForBuyHotSearch.matches("^[1-9][0-9]*");
    }

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

    static boolean isEnoughPriceForBuyHotSearch(int buyRankOfHotSearch, int priceForBuyHotSearch) {
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
