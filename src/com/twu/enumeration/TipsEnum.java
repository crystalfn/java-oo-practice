package com.twu.enumeration;

public enum TipsEnum {
    ASK_USERTYPE("欢迎来到热搜排行榜，你是？\n"),
    USER_TYPE_WRONG("没有此类用户角色，请重新选择！\n"),
    OPERATION_TYPE_WRONG("没有此类操作，已退出！\n"),
    HOME("已经退回主菜单！\n"),
    EXIT("已退出系统！"),
    ASK_NICKNAME("请输入您的昵称："),
    ASK_PASSWORD("请输入您的密码："),
    ERROR_ID("账号不存在！\n"),
    INPUT_HOT_SEARCH_NAME("请输入您要添加的热搜事件的名称："),
    ADD_HOT_SEARCH_SUCCESS("添加热搜成功！\n"),
    ADD_HOT_SEARCH_FAIL("添加热搜失败！\n"),
    INPUT_SUPER_HOT_SEARCH_NAME("请输入您要添加的超级热搜事件的名称："),
    ADD_SUPER_HOT_SEARCH_SUCCESS("添加超级热搜成功！\n"),
    ADD_SUPER_HOT_SEARCH_FAIL("添加超级热搜失败！\n"),
    INPUT_VOTE_HOT_SEARCH_NAME("请输入您要投票的热搜的名称："),
    INVALID_VOTE_HOT_SEARCH_NAME("您输入的要投票的热搜名称错误！\n"),
    INPUT_VOTE_VALUE("请输入您要投票的热搜票数："),
    VOTE_SUCCESS("投票成功！\n"),
    VOTE_FAIL("投票失败！\n"),
    INPUT_BUY_HOT_SEARCH_NAME("请输入您要购买的热搜的名称："),
    INVALID_BUY_HOT_SEARCH_NAME("您输入的要购买的热搜名称错误！"),
    INPUT_BUY_HOT_VALUE("请输入您要购买的热搜排名："),
    INVALID_BUY_HOT_VALUE("您输入的要购买的热搜排名错误！"),
    INPUT_BUY_HOT_SEARCH_PRICE("请输入您要购买的热搜金额："),
    INVALID_INPUT_PRICE("您输入的金额不符合要求，请输入正整数！"),
    INVALID_BUY_HOT_SEARCH_PRICE("您输入的金额无法购买该热搜！"),
    BUY_SUCCESS("购买热搜成功！\n"),
    BUY_FAIL("购买热搜失败！\n"),
    WRONG_INPUT("输入信息有误，已退出系统！");

    private final String description;

    TipsEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
