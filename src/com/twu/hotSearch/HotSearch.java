package com.twu.hotSearch;

public class HotSearch {
    private final String description;
    private final Boolean isSuper;
    private int hotValue = 0;
    private Boolean isPurchased = false;
    private int currentPurchasingPrice = 0;

    public HotSearch(String description, Boolean isSuper) {
        this.description = description;
        this.isSuper = isSuper;
    }

    public String getDescription() {
        return description;
    }

    public int getHotValue() {
        return hotValue;
    }

    public Boolean getIsSuper() {
        return isSuper;
    }

    public void setHotValue(int hotValue) {
        this.hotValue = hotValue;
    }

    public Boolean getPurchased() {
        return isPurchased;
    }

    public void setPurchased(Boolean purchased) {
        isPurchased = purchased;
    }

    public int getCurrentPurchasingPrice() {
        return currentPurchasingPrice;
    }

    public void setCurrentPurchasingPrice(int currentPurchasingPrice) {
        this.currentPurchasingPrice = currentPurchasingPrice;
    }
}
