package com.MainJavaFolder.ShoppingOnlineMain.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MainJavaFolder.ShoppingOnlineMain.Model.Message;
import com.MainJavaFolder.ShoppingOnlineMain.Model.User;
import com.MainJavaFolder.ShoppingOnlineMain.Service.EmailService;
import com.MainJavaFolder.ShoppingOnlineMain.Service.UserService;
import com.MainJavaFolder.ValidateUser.Validate;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class UsersController {

    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;



    @PostMapping("/register")
    public String registerUser(@RequestBody User user )
    {
        //System.out.println(user);
        String message = userService.createUser(user);
        
        return message;
    }

    @PostMapping("/login")
    public String checkUser(@RequestBody User user, HttpServletResponse response)
    {
        String message = userService.getUser(user.getUsername(), user.getPassword(), response);


        return message;
    }

    @GetMapping("/login")
    public String getUser(HttpServletRequest request)
    {
        String message = userService.validateUser(request.getCookies());
    
        return message;

    }
     @GetMapping("/login/user/{uid}")
    public String getUser(@PathVariable("uid") int uid)
    {
        User owner = userService.getUserInfoByUid(uid);
    
        return owner.getUsername();

    }

    @PostMapping("/login/message")
    public String postMessage(@RequestBody Message messages, HttpServletRequest request)
    {
        Validate v = new Validate();
        String m = v.validateUser(request.getCookies());

        if(m == "Sign In")
        {
            return "Sign In";
        }


        User reciever = userService.getUserInfoByUid( Integer.parseInt(messages.getUid()));

       // System.out.println(reciever.getEmail());
        emailService.sendEmail(reciever.getEmail(), "From Summer Shop", messages.getMessage());





       
        return null;
        
    }



}
