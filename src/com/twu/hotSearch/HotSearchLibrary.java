package com.twu.hotSearch;

import java.util.ArrayList;
import java.util.List;

public class HotSearchLibrary {
    public static final List<HotSearch> hotSearchList = new ArrayList<>();

    public static String viewHotSearch() {
        StringBuilder hotSearches = new StringBuilder();
        int index = 1;
        hotSearchList.sort((t1, t2) -> t2.getHotValue() - t1.getHotValue());
        for (HotSearch hotSearch : hotSearchList) {
            hotSearches
                .append(index).append(" ")
                .append(hotSearch.getDescription()).append(" ")
                .append(hotSearch.getHotValue()).append("\n");
            index++;
        }
        return hotSearches.toString();
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
            .noneMatch(hotSearch -> hotSearch.getDescription().equals(newHotSearch));
    }
}
