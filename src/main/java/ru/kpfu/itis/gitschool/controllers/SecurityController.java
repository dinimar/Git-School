package ru.kpfu.itis.gitschool.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.gitschool.models.User;

@Controller
public class SecurityController {
    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
//    @PreAuthorize("isAnonymous()")
    public String signUp(ModelMap map) {
        map.put("user", new User());
        return showSignUpForm(map);
    }

    protected String showSignUpForm(ModelMap map) {
        return "security/sign-up";
    }
}
