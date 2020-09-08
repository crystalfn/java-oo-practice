package com.twu.enumeration;

public enum OperationTypeEnum {
    VIEW_HOT_SEARCH("查看热搜排行榜\n"),
    ADD_HOT_SEARCH("添加热搜\n"),
    ADD_SUPPER_HOT_SEARCH("添加超级热搜\n"),
    VOTE_FOR_HOT_SEARCH("给热搜事件投票\n"),
    BUY_HOT_SEARCH("购买热搜\n"),
    EXIT("退出");

    private final String value;
    OperationTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
