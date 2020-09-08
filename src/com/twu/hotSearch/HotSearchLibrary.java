package com.twu.hotSearch;

import java.util.ArrayList;
import java.util.List;

public class HotSearchLibrary {
    private static final List<HotSearch> hotSearchList = new ArrayList<>();

    public static String viewHotSearch() {
        StringBuilder hotSearches = new StringBuilder();
        int index = 1;
        for (HotSearch hotSearch : hotSearchList) {
            hotSearches
                .append(index).append(" ")
                .append(hotSearch.getDescription()).append(" ")
                .append(hotSearch.getHotValue()).append("\n");
            index++;
        }
        return hotSearches.toString();
    }

    public static void addHotSearch(String hotSearch) {
        HotSearch addHotSearch = new HotSearch(hotSearch);
        if (isNewHotSearch(hotSearch)) {
            hotSearchList.add(addHotSearch);
        }
    }

    private static boolean isNewHotSearch(String newHotSearch) {
        return hotSearchList
            .stream()
            .noneMatch(hotSearch -> hotSearch.getDescription().equals(newHotSearch));
    }
}
