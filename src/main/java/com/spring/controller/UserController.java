package com.spring.controller;

import com.spring.model.User;
import com.spring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.spring.service")
public class UserController {

    private UserServiceImpl userService = new UserServiceImpl();
    /*
    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }*/

    @PostMapping(value = "add")
    public ModelAndView addUserPost(User messageUser) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setName(messageUser.getName());
        user.setMessage(messageUser.getMessage());
        userService.addUser(messageUser);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping(value = "delete")
    public ModelAndView deleteUsersPost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping(value = "update")
    public ModelAndView updateUsersPost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping(value = "/")//поставил заглушку
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", null);
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }

    @GetMapping(value = "add")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @GetMapping(value = "delete")
    public ModelAndView deleteUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteUser");
        return modelAndView;
    }

    @GetMapping(value = "update")
    public ModelAndView updateUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");
        return modelAndView;
    }

}
