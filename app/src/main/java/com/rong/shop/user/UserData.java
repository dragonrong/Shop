package com.rong.shop.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/29.
 */
public class UserData implements IUserData {
    private Map<String,User> users=null;

    public UserData() {
        users =new HashMap<>();

        User user=new User("123","123");
        this.insert(user);
    }

    @Override
    public void insert(User user) {
        users.put(user.getUserName(),user);
    }

    @Override
    public User getUserByName(String userName) {
        return users.get(userName);
    }
}
