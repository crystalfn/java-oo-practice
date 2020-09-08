package com.twu.enumeration;

public enum OperationTypeEnum {
    VIEW_HOT_SEARCH("查看热搜排行榜"),
    ADD_HOT_SEARCH("添加热搜"),
    ADD_SUPPER_HOT_SEARCH("添加超级热搜"),
    VOTE_FOR_HOT_SEARCH("给热搜事件投票"),
    BUY_HOT_SEARCH("购买热搜"),
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
