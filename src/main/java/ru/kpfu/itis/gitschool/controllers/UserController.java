package ru.kpfu.itis.gitschool.controllers;

import com.google.gson.Gson;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.itis.gitschool.utils.APIHelper;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/git-update", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String updateName(@RequestBody String body, ModelMap map) {
        Gson gson = new Gson();
        try {
            String response = APIHelper.myGetRequest("https://api.github.com");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#profile").build();
    }
}
