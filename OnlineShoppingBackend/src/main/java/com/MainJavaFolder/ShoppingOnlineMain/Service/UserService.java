package com.MainJavaFolder.ShoppingOnlineMain.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainJavaFolder.ShoppingOnlineMain.Model.User;
import com.MainJavaFolder.ShoppingOnlineMain.dao.UserDao;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    
    
}
