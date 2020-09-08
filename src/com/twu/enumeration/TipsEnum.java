package com.twu.enumeration;

public enum TipsEnum {
    ASK_USERTYPE("欢迎来到热搜排行榜，你是？\n"),
    USER_TYPE_WRONG("没有此类用户角色，已退出！\n"),
    OPERATION_TYPE_WRONG("没有此类操作，已退出！\n"),
    HOME("已经退回主菜单！\n"),
    EXIT("已退出！"),
    ASK_NICKNAME("请输入您的昵称："),
    ASK_PASSWORD("请输入您的密码："),
    ERROR_ID("账号不存在！\n"),
    INPUT_HOT_SEARCH_NAME("请输入您要添加的热搜事件的名称："),
    INPUT_SUPER_HOT_SEARCH_NAME("请输入您要添加的超级热搜事件的名称："),
    INPUT_VOTE_HOT_SEARCH_NAME("请输入您要投票的热搜的名称："),
    INVALID_VOTE_HOT_SEARCH_NAME("您输入的要投票的热搜名称错误！\n"),
    INPUT_VOTE_VALUE("请输入您要投票的热搜票数："),
    VOTE_SUCCESS("投票成功！\n"),
    VOTE_FAIL("投票失败！\n");

    private final String description;

    TipsEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
