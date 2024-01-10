package com.MainJavaFolder.ShoppingOnlineMain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MainJavaFolder.ShoppingOnlineMain.Model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

   public User findByUsername(String username);

   public User getReferenceByUid(int uid);



    
}
