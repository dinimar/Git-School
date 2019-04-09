package ru.kpfu.itis.gitschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.gitschool.models.Student;
import ru.kpfu.itis.gitschool.repositories.HomeTaskRepository;
import ru.kpfu.itis.gitschool.repositories.StudentRepository;

@Controller
public class UserController {
    @Autowired
    private StudentRepository studRepo;
    @Autowired
    private HomeTaskRepository homeTaskRepo;

    @RequestMapping("/sign-up")
    public String addUser(ModelMap map) {
        return "sign-up";
    }

    @RequestMapping(value = "/student/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Student student, ModelMap map) {
        map.put("student", student);
        return showForm(map);
    }

    @RequestMapping("/assign-ht")
    public String assignHomeTask(ModelMap map) {
        return "assign-ht";
    }

    protected String showForm(ModelMap map) {
        map.put("home_tasks", homeTaskRepo.findAll());
        return "students/form";
    }
}
