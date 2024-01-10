package com.MainJavaFolder.ShoppingOnlineMain.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.MainJavaFolder.ShoppingOnlineMain.Model.User;
import com.MainJavaFolder.ShoppingOnlineMain.dao.UserDao;
import com.MainJavaFolder.ValidateUser.Validate;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {

    @Autowired
    UserDao userDao;



    public Optional<User> getAllUsers(int n) {

        
        return userDao.findById(n);
    }

    public String createUser(User customer) {

        String userName = customer.getUsername().toString();
        if(userDao.findByUsername(userName) == null)
        {
            userDao.save(customer);
        }
        else {
            return "Username Taken. Please Try Again";
        }

        // if(userDao.getByUsername("jason") == customer){

        // }
        return "Registered!";

        
    }

    public String getUser(String username, String password, HttpServletResponse response) {

        User user = userDao.findByUsername(username);
        


        if(user != null && username.equals(user.getUsername()) && user.getPassword().equals(password))
        {
            Cookie newCookie = new Cookie("username", user.getUsername());
            newCookie.setHttpOnly(true);
            newCookie.setSecure(true);
            response.addCookie(newCookie);
            return "Success";
        }

        
        return "Incorrect Login Info";
    }

    public String validateUser(Cookie[] cookies) {
        
        Validate v = new Validate();

        String message = v.validateUser(cookies);

   
       
        return message;
        


    }

    public User getUserInfoByUid(int uid) {
        User u = new User();
         u = userDao.getReferenceByUid(uid);
        return u;
    }

    public User getUserByUsername(String username) {

        User u = userDao.findByUsername(username);
        return u;
    }

    
    
}
