package ru.kpfu.itis.gitschool.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.gitschool.models.HomeTask;

@Controller
@RequestMapping("/hometask")
public class HomeTaskController {
    @RequestMapping(value = "/assign", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String assignHomeTask(ModelMap map) {
        map.put("hometask", new HomeTask());
        return "hometasks/assign";
    }
}
