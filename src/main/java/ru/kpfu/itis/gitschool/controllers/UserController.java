package ru.kpfu.itis.gitschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("sign-up")
    public String addUser(ModelMap map) {
        return "home";
    }
}
