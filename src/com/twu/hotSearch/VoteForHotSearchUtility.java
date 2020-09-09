package com.twu.hotSearch;

import com.twu.enumeration.TipsEnum;

import java.util.Scanner;

public class VoteForHotSearchUtility {
    static Scanner scanner = new Scanner(System.in);
    private static int currentPoll;

    public static int getCurrentPoll() {
        return currentPoll;
    }

    static boolean isValidHotSearchName(String hotSearchName) {
        return HotSearchLibrary.hotSearchList
            .stream()
            .anyMatch(hotSearch -> hotSearchName.equals(hotSearch.getDescription()));
    }

    static void voteForValidHotSearch(String hotSearchName, int poll) {
        int voteHotSearchValue;
        voteHotSearchValue = getVoteValue(poll);
        if (voteHotSearchValue > poll) {
            System.out.println(TipsEnum.VOTE_FAIL);
        } else {
            currentPoll = poll - voteHotSearchValue;
            updateHotSearchHotValue(hotSearchName, voteHotSearchValue);
            System.out.println(TipsEnum.VOTE_SUCCESS);
        }
    }

    static int getVoteValue(int poll) {
        System.out.println(TipsEnum.INPUT_VOTE_VALUE + "您目前还有" + poll + "票");
        int voteHotSearchValue;
        try {
            voteHotSearchValue = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return voteHotSearchValue;
    }

    static void updateHotSearchHotValue(String hotSearchName, int voteHotSearchValue) {
        HotSearchLibrary.hotSearchList.forEach(hotSearch -> {
            if (hotSearch.getDescription().equals(hotSearchName)) {
                int voteValue = hotSearch.getIsSuper() ? voteHotSearchValue * 2 : voteHotSearchValue;
                hotSearch.setHotValue(hotSearch.getHotValue() + voteValue);
            }
        });
    }
}
