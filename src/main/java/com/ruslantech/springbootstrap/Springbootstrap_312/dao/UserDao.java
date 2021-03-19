package com.ruslantech.springbootstrap.Springbootstrap_312.dao;

import com.ruslantech.springbootstrap.Springbootstrap_312.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

   void add(User user);

   Set<User> listUsers();

   void remove(Long id);

   void update(User user);

   User getUserById(Long id);

   User getUserByFirstName(String name);

   boolean checkUserById(Long id);

}
