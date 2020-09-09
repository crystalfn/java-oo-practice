package com.twu.hotSearch;

public class HotSearch {
    private final String description;
    private final Boolean isSuper;
    private int hotValue = 0;
    private int rank = Integer.MAX_VALUE;
    private int currentPurchasingPrice = 0;

    public HotSearch(String description, Boolean isSuper) {
        this.description = description;
        this.isSuper = isSuper;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsSuper() {
        return isSuper;
    }

    public int getHotValue() {
        return hotValue;
    }

    public void setHotValue(int hotValue) {
        this.hotValue = hotValue;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCurrentPurchasingPrice() {
        return currentPurchasingPrice;
    }

    public void setCurrentPurchasingPrice(int currentPurchasingPrice) {
        this.currentPurchasingPrice = currentPurchasingPrice;
    }
}
