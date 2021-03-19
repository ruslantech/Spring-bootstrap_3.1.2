package com.ruslantech.springbootstrap.Springbootstrap_312.service;

import com.ruslantech.springbootstrap.Springbootstrap_312.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruslantech.springbootstrap.Springbootstrap_312.dao.RoleDao;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}
