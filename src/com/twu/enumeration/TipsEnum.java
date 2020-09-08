package com.twu.enumeration;

public enum TipsEnum {
    ASK_USERTYPE("欢迎来到热搜排行榜，你是？"),
    USER_TYPE_WRONG("没有此类用户角色，已退出!"),
    OPERATION_TYPE_WRONG("没有此类操作，已退出!"),
    EXIT("已退出！"),
    ASK_NICKNAME("请输入您的昵称："),
    INPUT_HOT_SEARCH_NAME("请输入你要添加的热搜事件的名字：");

    private final String description;

    TipsEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
