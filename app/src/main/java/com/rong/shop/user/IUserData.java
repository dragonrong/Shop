package com.rong.shop.user;

/**
 * Created by Administrator on 2016/7/29.
 */
public interface IUserData {
    public void insert(User user);
    public User getUserByName(String userName);
}

