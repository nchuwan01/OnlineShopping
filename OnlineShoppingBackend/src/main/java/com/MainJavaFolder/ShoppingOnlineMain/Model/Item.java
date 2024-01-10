package com.MainJavaFolder.ShoppingOnlineMain.Model;


import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
     private int pid;
     private String name;
     private String description;
     private String category;
     private double price;
     private String image; 
     private int uid;
     @CreationTimestamp
     private Date created_at;
     
     public Item()
     {
          
     }


     public Item(String name, String description, String category, double price, String image)
     {
          this.name = name;
          this.description = description;
          this.category = category;
          this.price = price;
          this.image = image;
     
     }
     public int getPid() {
          return pid;
     }
     public void setPid(int pid) {
          this.pid = pid;
     }
     public String getName() {
          return name;
     }
     public void setName(String name) {
          this.name = name;
     }
     public String getDescription() {
          return description;
     }
     public void setDescription(String description) {
          this.description = description;
     }
     public String getCategory() {
          return category;
     }
     public void setCategory(String category) {
          this.category = category;
     }
     public double getPrice() {
          return price;
     }
     public void setPrice(double price) {
          this.price = price;
     }
     public String getImage() {
          return image;
     }
     public void setImage(String image) {
          this.image = image;
     }
     public int getUid() {
          return uid;
     }
     public void setUid(int uid) {
          this.uid = uid;
     }

     public Date getCreated_at() {
          return created_at;
     }

     public void setCreated_at(Date created_at) {
          this.created_at = created_at;
     }


     
    
    
}
