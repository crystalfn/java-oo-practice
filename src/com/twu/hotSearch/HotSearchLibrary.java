package com.twu.hotSearch;

import java.util.ArrayList;
import java.util.List;

public class HotSearchLibrary {
    public static final List<HotSearch> hotSearchList = new ArrayList<>();

    public static String viewHotSearch() {
        final List<HotSearch> buyHotSearchList = ViewHotSearchUtility.getBuyHotSearchList();
        List<HotSearch> commonHotSearchList = ViewHotSearchUtility.getCommonHotSearchList();

        StringBuilder hotSearches = ViewHotSearchUtility.getHotSearches(buyHotSearchList, commonHotSearchList);
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
            .noneMatch(hotSearch -> hotSearch.getDescription().equalsIgnoreCase(newHotSearch));
    }
}
