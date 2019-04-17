package ru.kpfu.itis.gitschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
//import ru.kpfu.itis.gitschool.models.Student;
//import ru.kpfu.itis.gitschool.models.User;
//import ru.kpfu.itis.gitschool.repositories.HomeTaskRepository;
//import ru.kpfu.itis.gitschool.repositories.StudentRepository;

import javax.validation.Valid;

@Controller
public class UserController {
//    @Autowired
//    private StudentRepository studRepo;
//    @Autowired
//    private HomeTaskRepository homeTaskRepo;

//    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
//    @PreAuthorize("isAnonymous()")
//    public String register(ModelMap map) {
//        map.put("user", new User());
//        return showSignUpForm(map);
//    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @PreAuthorize("isAnonymous()")
//    public String registerHandler(
//            RedirectAttributes redirectAttributes,
//            @ModelAttribute("user") @Valid User user,
//            BindingResult result,
//            ModelMap map
//    ) {
//        if (!result.hasErrors()) {
//            try{
//                userService.registerUser(user);
//                redirectAttributes.addFlashAttribute("message", "You has been registered successfully");
//                redirectAttributes.addFlashAttribute("messageType", "success");
//                return "redirect:" + UriComponentsBuilder.fromPath("/").build();
//            }
//            catch(DuplicateKeyException ex){
//                result.rejectValue("username", "entry.duplicate", "There is account with such email already.");
//            }
//        }
//        return showSignUpForm(map);
//    }

//    @RequestMapping(value = "/student/{id}/assign-ht", method = RequestMethod.GET)
//    public String edit(@PathVariable("id") Student student, ModelMap map) throws Exception {
//        if (student == null) {
//            throw new Exception("Student was not found");
//        }
//        map.put("student", student);
//
//        return showForm(map);
//    }
//
//    @RequestMapping(value = "/student/{id}/assign-ht", method = RequestMethod.POST)
//    public String edit(
//            RedirectAttributes redirectAttributes,
//            @ModelAttribute("book") Student student,
//            BindingResult result,
//            ModelMap map) {
//        studRepo.save(student);
//
//        map.put("student", student);
//        return showForm(map);
//    }

//    protected String showForm(ModelMap map) {
//        map.put("options", homeTaskRepo.findAll());
//        return "form";
//    }

//    protected String showSignUpForm(ModelMap map) {
//        return "security/sign-up";
//    }
}
