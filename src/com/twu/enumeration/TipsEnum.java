package com.twu.enumeration;

public enum TipsEnum {
    ASK_USERTYPE("欢迎来到热搜排行榜，你是？"),
    USER_WRONG("没有此类用户角色，已退出!"),
    EXIT("已退出！"),
    ASK_NICKNAME("请输入您的昵称：");

    private final String description;

    TipsEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
