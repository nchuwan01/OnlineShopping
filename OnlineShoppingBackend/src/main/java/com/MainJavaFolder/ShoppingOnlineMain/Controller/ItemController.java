package com.MainJavaFolder.ShoppingOnlineMain.Controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MainJavaFolder.ShoppingOnlineMain.Model.Item;
import com.MainJavaFolder.ShoppingOnlineMain.Service.ItemService;
import com.MainJavaFolder.ShoppingOnlineMain.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    UserService uService;

    private static final String UPLOAD_PATH = "C:/Users/Narayan/ShoppingOnline/OnlineShoppingBackend/src/main/resources/static/images/";



    @GetMapping("/login/{category}")
    public Item[] getTextbooks(@PathVariable("category") String Category)
    {
        try{
            Item[] item = itemService.findAllByCategory(Category);
            return item;
        }catch(Exception E)
        {
            return null;
        }


    }

    @GetMapping("/login/item/{id}")
    public Object getItemByID(@PathVariable("id") int itemID)
    {
        try{
            Object item = itemService.findByID(itemID);
            return item;
        }catch(Exception E)
        {
            return null;
        }

    }


    

    @PostMapping("/login/sell")
    public String sellItem(@RequestParam("image") MultipartFile file, 
                        @RequestParam("name") String name,
                        @RequestParam("description") String description,
                        @RequestParam("category") String category,
                        @RequestParam("price") double price,
                        HttpServletRequest req) throws IOException
    {

        String data = uService.validateUser(req.getCookies());
        if(data.equals("Sign In")){return "Sign In";};

        Item item = new Item(name, description, category, price, file.getOriginalFilename());
        itemService.sellItem(item, req.getCookies(), file, UPLOAD_PATH, file.getOriginalFilename());
           
        return "On Sale!";
    }

    @PostMapping("/login/images/{image}")
    public ResponseEntity<byte[]> imageUpload(@PathVariable("image") String imageName )
    {
        ResponseEntity<byte[]> sendImage = itemService.sendImage(UPLOAD_PATH, imageName);
        return sendImage;
    }


    @GetMapping("/login/delete/{itemID}")
    public void deleteItem(@PathVariable("itemID") int itemID)
    {
        itemService.deleteItemByID(itemID);

    }

    
    
}
