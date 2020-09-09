package com.twu.hotSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotSearchLibrary {
    public static final List<HotSearch> hotSearchList = new ArrayList<>();

    public static String viewHotSearch() {
        final List<HotSearch> buyHotSearchList = getBuyHotSearchList();
        List<HotSearch> commonHotSearchList = getCommonHotSearchList();

        StringBuilder hotSearches = getHotSearches(buyHotSearchList, commonHotSearchList);
        return hotSearches.toString();
    }

    private static List<HotSearch> getBuyHotSearchList() {
        List<HotSearch> buyHotSearchList = new ArrayList<>();
        hotSearchList.forEach(hotSearch -> {
            if (hotSearch.getCurrentPurchasingPrice() > 0) {
                buyHotSearchList.add(hotSearch);
            }
        });
        return buyHotSearchList;
    }

    private static List<HotSearch> getCommonHotSearchList() {
        List<HotSearch> tempHotSearchList;
        tempHotSearchList = HotSearchLibrary.hotSearchList;
        return tempHotSearchList
            .stream()
            .filter(hotSearch -> hotSearch.getCurrentPurchasingPrice() == 0)
            .sorted((hotSearch, t1) -> t1.getHotValue() - hotSearch.getHotValue())
            .collect(Collectors.toList());
    }

    private static StringBuilder getHotSearches(List<HotSearch> buyHotSearchList, List<HotSearch> commonHotSearchList) {
        StringBuilder hotSearches = new StringBuilder();
        int index = 1;
        for (HotSearch hotSearch : commonHotSearchList) {
            for (HotSearch h1 : buyHotSearchList) {
                if (h1.getRank() == index) {
                    hotSearches
                        .append(index).append(" ")
                        .append(h1.getDescription()).append(" ")
                        .append(h1.getHotValue()).append("\n");
                    index++;
                }
            }
            hotSearches
                .append(index).append(" ")
                .append(hotSearch.getDescription()).append(" ")
                .append(hotSearch.getHotValue()).append("\n");
            index++;
        }
        return hotSearches;
    }

    public static void addHotSearch(String hotSearch, Boolean isSuper) {
        HotSearch addHotSearch = new HotSearch(hotSearch, isSuper);
        if (isNewHotSearch(hotSearch)) {
            hotSearchList.add(addHotSearch);
        }
    }

    private static boolean isNewHotSearch(String newHotSearch) {
        return hotSearchList
            .stream()
            .noneMatch(hotSearch -> hotSearch.getDescription().equalsIgnoreCase(newHotSearch));
    }
}
