package com.MainJavaFolder.ValidateUser;

import org.springframework.beans.factory.annotation.Autowired;

import com.MainJavaFolder.ShoppingOnlineMain.Model.User;
import com.MainJavaFolder.ShoppingOnlineMain.dao.UserDao;

import jakarta.servlet.http.Cookie;

public class Validate {

    @Autowired
    UserDao userDao;

    public String validateUser(Cookie[] cookies)
    {
        Cookie[] data = cookies;

        if(data != null)
        {
            for(Cookie name : data)
            {
                if(name.getName().equals("username"))
                {
                    return name.getValue();
                }
            
            }

        }


        return "Sign In";
        
    }
    
}
