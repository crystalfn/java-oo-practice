package com.twu.hotSearch;

import java.util.List;
import java.util.stream.Collectors;

class ViewHotSearchUtility {
    static List<HotSearch> getBuyHotSearchList() {
        return HotSearchLibrary.hotSearchList
            .stream()
            .filter(hotSearch -> hotSearch.getCurrentPurchasingPrice() > 0)
            .collect(Collectors.toList());
    }

    static List<HotSearch> getCommonHotSearchList() {
        return HotSearchLibrary.hotSearchList
            .stream()
            .filter(hotSearch -> hotSearch.getCurrentPurchasingPrice() == 0)
            .sorted((hotSearch, t1) -> t1.getHotValue() - hotSearch.getHotValue())
            .collect(Collectors.toList());
    }

    static StringBuilder getHotSearches(List<HotSearch> buyHotSearchList, List<HotSearch> commonHotSearchList) {
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
}
