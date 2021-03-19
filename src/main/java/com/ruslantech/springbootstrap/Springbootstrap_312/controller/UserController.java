package com.ruslantech.springbootstrap.Springbootstrap_312.controller;

import com.ruslantech.springbootstrap.Springbootstrap_312.model.User;
import com.ruslantech.springbootstrap.Springbootstrap_312.service.RoleService;
import com.ruslantech.springbootstrap.Springbootstrap_312.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    private UserService userService;

    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String getUsers(Model model){
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("roles", roleService.getRoles());
        return "admin_page";
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("users", userService.getUserByFirstName(auth.getName()));
        return "user_page";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "role") Long[] rolesId){

        userService.add(user, rolesId);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/delete")
    public String deleteUser(@ModelAttribute("id") Long id){
        userService.remove(id);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "role", required = false) Long[] rolesId){

        for(Long id: rolesId) {
            System.out.println(id);
        }

        userService.update(user, rolesId);
        return "redirect:/admin";
    }
}
