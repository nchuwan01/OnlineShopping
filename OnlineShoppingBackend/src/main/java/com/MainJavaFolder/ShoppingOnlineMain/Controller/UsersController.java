package com.MainJavaFolder.ShoppingOnlineMain.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MainJavaFolder.ShoppingOnlineMain.Model.User;
import com.MainJavaFolder.ShoppingOnlineMain.Service.UserService;

@CrossOrigin
@RestController
public class UsersController {

    @Autowired
    UserService userService;

    // @PostMapping("/register")
    // public String registerUser(@RequestBody String data)
    // {
    //     System.out.println(data);
    //     return  "Hello";
    // }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    
    // @GetMapping("/show")
    // public String Check()
    // {
    //     return "hoa";
    // }
}
