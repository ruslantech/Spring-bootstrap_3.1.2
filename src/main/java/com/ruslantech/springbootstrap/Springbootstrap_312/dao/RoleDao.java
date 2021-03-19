package com.ruslantech.springbootstrap.Springbootstrap_312.dao;

import com.ruslantech.springbootstrap.Springbootstrap_312.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoles();

    Role getRoleById(Long id);

}
