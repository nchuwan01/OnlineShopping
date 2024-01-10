package com.MainJavaFolder.ShoppingOnlineMain.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MainJavaFolder.ShoppingOnlineMain.Model.Item;
import com.MainJavaFolder.ShoppingOnlineMain.dao.ItemDao;
import com.MainJavaFolder.ShoppingOnlineMain.dao.UserDao;

import org.springframework.web.multipart.MultipartFile;


import jakarta.servlet.http.Cookie;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;
    @Autowired
    UserDao userDao;

    @Autowired
    UserService uService;

    public String sellItem(Item post , Cookie[] cookies, MultipartFile file, String Upload_Path, String fileName) {
        
        Cookie[] data = cookies;

        String username = uService.validateUser(cookies);
        if(username.equals("Sign In")) {return "Sign In"; };

        post.setUid(userDao.findByUsername(username).getUid());
        try {
            file.transferTo(new File(Upload_Path + fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       


   

        // if(data != null)
        // {
        //     for(Cookie name : data)
        //     {
        //         if(name.getName().equals("username"))
        //         {
        //             post.setUid(userDao.findByUsername(name.getValue()).getUid());
        //         }
            
        //     }

        // }
        itemDao.save(post);
        return "saved";
    }

    public Item[] findAllByCategory(String category) {
        return itemDao.findAllByCategory(category);
    }

    public Object findByID(int itemID) {

        Item item = itemDao.getReferenceById(itemID);
        HashMap<String, String> obj = new HashMap<>();

        obj.put("uid", Integer.toString(item.getUid()));
        obj.put( "name", item.getName());
        obj.put("description", item.getDescription());
        obj.put("category",item.getCategory());
        obj.put("price", Double.toString(item.getPrice()));
        obj.put("image", item.getImage());
        
        return obj;
    }

    public void deleteItemByID(int itemID)
    {
        //itemDao.deleteByPid(itemID);
        itemDao.deleteById(itemID);


    }

    public ResponseEntity<byte[]> sendImage(String uploadPath, String imageName) {
        try {
            Path imagePath = Paths.get(uploadPath, imageName);
            byte[] imageData = Files.readAllBytes(imagePath);

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
        } catch (IOException e) {
            // Handle image retrieval exception
            return ResponseEntity.notFound().build();
        }    
    }
    
    
}
