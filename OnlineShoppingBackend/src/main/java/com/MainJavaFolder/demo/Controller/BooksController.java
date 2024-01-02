package com.MainJavaFolder.demo.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BooksController {

    @PostMapping("/register")
    public String Checkout()
    {
        System.out.println("Success!");
        return "You've Been Registered!";
    }
    
    @GetMapping("/show")
    public String Check()
    {
        return "hoa";
    }
}
