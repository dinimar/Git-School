package ru.kpfu.itis.gitschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.gitschool.exceptions.NotFoundException;
import ru.kpfu.itis.gitschool.models.HomeTask;
import ru.kpfu.itis.gitschool.models.User;
import ru.kpfu.itis.gitschool.services.HomeTaskService;
import ru.kpfu.itis.gitschool.services.SecureTokenService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/hometask")
public class HomeTaskController {
    @Autowired
    private HomeTaskService homeTaskService;
    @Autowired
    private SecureTokenService tokenService;

    @RequestMapping(value = "/{id}")
    @PreAuthorize("isAuthenticated()")
    public String showHometask(@PathVariable("id") HomeTask homeTask, ModelMap map) {
        map.put("hometask", homeTask);
        return "hometasks/info";
    }

    @RequestMapping(value = "/assign", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String getHomeTaskAssigningPage(ModelMap map) {
        map.put("hometask", new HomeTask());
        map.put("token", tokenService.getToken());
        return "hometasks/assign";
    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String assignHomeTask(Principal principal,
                                 RedirectAttributes redirectAttributes,
                                 @ModelAttribute("hometask") @Valid HomeTask homeTask,
                                 BindingResult result,
                                 ModelMap map) {
        User signedInUser = getUserFromPrincipal(principal);

        if (!result.hasErrors()) {
            try {
                homeTaskService.assignHomeTask(signedInUser, homeTask);
                redirectAttributes.addFlashAttribute("message", "Home task is assigned");
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("HTC#getHomeTaskAssigningPage").build();
            } catch (DuplicateKeyException ex) {
                result.rejectValue("date", "entry.duplicate", "Two homeworks on one date are not permitted.");
            }
        } else {
            map.put("error", "Use only future dates!");
        }

        return "hometasks/assign";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String getHomeTaskSubmittingPage(ModelMap map, Principal principal) {
        map.put("user", getUserFromPrincipal(principal));
        map.put("options", homeTaskService.getAll());
        return "hometasks/submit";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String submitHomeTask(Principal principal,
                                 RedirectAttributes redirectAttributes,
                                 ModelMap map,
                                 User user) {
        homeTaskService.submitHomeTask(getUserFromPrincipal(principal), user.getSubmittedHomeTasks());
        redirectAttributes.addFlashAttribute("message", "Home task is submitted");
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("HTC#getHomeTaskSubmittingPage").build();
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String getDeletingHomeTaskPage(@PathVariable("id") HomeTask homeTask, ModelMap map) {
        map.put("hometask", homeTask);
        return "hometasks/assign";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String deleteHomeTask(@PathVariable("id") int id, HomeTask homeTask, ModelMap map) {
        homeTaskService.updateHomeTask(homeTask);

        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("HTC#shoeHomeTaskList").build();
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String deleteHomeTask(@PathVariable("id") HomeTask homeTask, Principal principal, ModelMap map) {
        homeTaskService.deleteHomeTask(getUserFromPrincipal(principal), homeTask);

        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("HTC#shoeHomeTaskList").build();
    }

    @RequestMapping(value = "/list")
    @PreAuthorize("isAuthenticated()")
    public String shoeHomeTaskList(ModelMap map) {
        List<HomeTask> homeTasks = homeTaskService.getAll();
        map.put("hometasks", homeTasks);

        return "hometasks/list";
    }

    private User getUserFromPrincipal(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        User signedInUser = (User) token.getPrincipal();

        return signedInUser;
    }
}
