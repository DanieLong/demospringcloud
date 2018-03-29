package com.lk.product.model;
/**
 * 用户信息DTO对象

 */
public class User {private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    private String loginName;                                   // 用户登陆名称
    private String name;                                        // 用户姓名
    private String avatar;                                      // 用户头像
    private String memos;                                       // 信息备注

    // ========================================================================
    // constructor ============================================================
    public User() {
    }

    public User(String loginName, String name, String avatar, String memos) {
        this.loginName = loginName;
        this.name = name;
        this.avatar = avatar;
        this.memos = memos;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMemos() {
        return memos;
    }

    public void setMemos(String memos) {
        this.memos = memos;
    }
}
