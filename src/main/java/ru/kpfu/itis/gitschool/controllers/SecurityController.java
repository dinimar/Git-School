package ru.kpfu.itis.gitschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.gitschool.models.User;
import ru.kpfu.itis.gitschool.models.forms.SignInForm;
import ru.kpfu.itis.gitschool.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String getSignInPage(@RequestParam(required = false) String error, @ModelAttribute("signInForm") SignInForm signInForm, BindingResult result, ModelMap map) {
        map.put("error", error);
        return showSignInForm(map);
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String getSignUpPage(ModelMap map) {
        map.put("user", new User());
        return showSignUpForm(map);
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String signUpUser(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("user") @Valid User user,
            BindingResult result,
            ModelMap map
    ) {
        if (!result.hasErrors()) {
            try {
                userService.signUpUser(user);
                redirectAttributes.addFlashAttribute("message", "You have been registered successfully");
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#getSignUpPage").build();
            } catch (DuplicateKeyException ex) {
                result.rejectValue("email", "entry.duplicate", "There is account with such email already.");
            }
        }
        return showSignUpForm(map);
    }

    @RequestMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(HttpServletRequest request) {
        return "security/profile";
    }

    protected String showSignUpForm(ModelMap map) {
        return "security/sign-up";
    }
    protected String showSignInForm(ModelMap map) {return "security/sign-in";}
}
