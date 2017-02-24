package com.rong.shop.user;

/**
 * Created by Administrator on 2016/7/29.
 */
public class UserManager {
    private IUserData dao;

    public UserManager() {
        dao=new UserData();
    }

    public User Login(String userName,String passWord){
        User user=dao.getUserByName(userName);
        if (user!=null){
            return user.getPassWord().equals(passWord)?user:null;
        }
        return null;
    }
    /*public User Register(User user){
        try {
            this.dao.insert(user);
            return user;
        }catch (Exception e){
            return null;
        }

    }*/
}
