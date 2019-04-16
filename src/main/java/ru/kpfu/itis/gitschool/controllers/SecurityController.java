package ru.kpfu.itis.gitschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.gitschool.models.User;
import ru.kpfu.itis.gitschool.services.UserService;

import javax.validation.Valid;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
//    @PreAuthorize("isAnonymous()")
    public String signUp(ModelMap map) {
        map.put("user", new User());
        return showSignUpForm(map);
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
//    @PreAuthorize("isAnonymous()")
    public String registerHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("user") @Valid User user,
            BindingResult result,
            ModelMap map
    ) {
        if (!result.hasErrors()) {
            try {
                userService.signUpUser(user);
                redirectAttributes.addFlashAttribute("message", "You have been registered successfully");
//                redirectAttributes.addFlashAttribute("messageType", "success");
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#signUp").build();
            } catch (DuplicateKeyException ex) {
                result.rejectValue("email", "entry.duplicate", "There is account with such email already.");
            }
        }
        return showSignUpForm(map);
    }

    protected String showSignUpForm(ModelMap map) {
        return "security/sign-up";
    }
}
