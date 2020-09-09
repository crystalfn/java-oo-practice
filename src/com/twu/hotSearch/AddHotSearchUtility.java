package com.twu.hotSearch;

class AddHotSearchUtility {
    static boolean isNewHotSearch(String newHotSearch) {
        return HotSearchLibrary.hotSearchList
            .stream()
            .noneMatch(hotSearch -> hotSearch.getDescription().equalsIgnoreCase(newHotSearch));
    }
}
