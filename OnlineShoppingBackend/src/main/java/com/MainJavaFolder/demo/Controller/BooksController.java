package com.MainJavaFolder.demo.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @PostMapping("/register")
    public String Checkout()
    {
        System.out.println("Success!");
        return "whatever!";
    }
    
}
