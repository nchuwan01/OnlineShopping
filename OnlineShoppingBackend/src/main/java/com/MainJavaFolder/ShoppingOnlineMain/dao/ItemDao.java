package com.MainJavaFolder.ShoppingOnlineMain.dao;

import org.springframework.stereotype.Repository;

import com.MainJavaFolder.ShoppingOnlineMain.Model.Item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;




@Repository
public interface ItemDao extends JpaRepository<Item, Integer>  {

    public Item[] findAllByCategory(String category);
    public Item getReferenceById(int id);
    
}
