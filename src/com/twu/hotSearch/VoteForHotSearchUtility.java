package com.twu.hotSearch;

class VoteForHotSearchUtility {
    static boolean isValidHotSearchName(String hotSearchName) {
        return HotSearchLibrary.hotSearchList
            .stream()
            .anyMatch(hotSearch -> hotSearchName.equalsIgnoreCase(hotSearch.getDescription()));
    }

    static int updateHotSearchHotValue(String hotSearchName, int poll, int inputPoll) {
        HotSearchLibrary.hotSearchList.forEach(hotSearch -> {
            if (hotSearch.getDescription().equals(hotSearchName)) {
                int voteValue = hotSearch.getIsSuper() ? inputPoll * 2 : inputPoll;
                hotSearch.setHotValue(hotSearch.getHotValue() + voteValue);
            }
        });
        return poll - inputPoll;
    }
}
