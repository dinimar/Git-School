package ru.kpfu.itis.gitschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @RequestMapping(value = "/student/{id}/assign-ht", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Student student, ModelMap map) throws Exception {
        if (student == null) {
            throw new Exception("Student was not found");
        }
        map.put("student", student);

        return showForm(map);
    }

    @RequestMapping(value = "/student/{id}/assign-ht", method = RequestMethod.POST)
    public String edit(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("book") Student student,
            BindingResult result,
            ModelMap map) {
        studRepo.save(student);

        map.put("student", student);
        return showForm(map);
    }

    @RequestMapping("/assign-ht")
    public String assignHomeTask(ModelMap map) {
        return "assign-ht";
    }

    protected String showForm(ModelMap map) {
        map.put("options", homeTaskRepo.findAll());
        return "form";
    }
}
