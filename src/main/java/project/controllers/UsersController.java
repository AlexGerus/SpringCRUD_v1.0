package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.module.Role;
import project.module.User;
import project.service.RoleService;
import project.service.UserService;
import java.io.IOException;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String index () {
        return "index";
    }

    @RequestMapping(value = "/mylogin")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/removeUser" , method = RequestMethod.GET)
    public String getDelete(@RequestParam(value = "id") long id, Model model) {
        roleService.removeRole((int) id);
        userService.removeUser(id);
        model.addAttribute("id", id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public String listUsers(Model model) throws IOException {
        List<User> list = userService.listUser();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("userAttribute", new User());
        model.addAttribute("roleAttribute", new Role());
        return "/addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("userAttribute") User user, @ModelAttribute("roleAttribute") Role role) {
        userService.addUser(user);
        roleService.addRole(user, role);
        return "redirect:/list";
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "idChange") long id,
                          @RequestParam(value = "nameChange") String name,
                          @RequestParam(value = "ageChange") int age,
                          @RequestParam(value = "loginChange") String login,
                          @RequestParam(value = "passwordChange") String password,
                          Model model) {

        model.addAttribute("idChange", id);
        model.addAttribute("nameChange", name);
        model.addAttribute("ageChange", age);
        model.addAttribute("loginChange", login);
        model.addAttribute("passwordChange", password);
        return "/changeUser";
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public String changeUser(@RequestParam(value = "idChange") long id,
                             @RequestParam(value = "nameChange") String name,
                             @RequestParam(value = "ageChange") int age,
                             @RequestParam(value = "loginChange") String login,
                             @RequestParam(value = "passwordChange") String password,
                             @ModelAttribute("changeUser") User profile) {
        profile.setId(id);
        profile.setName(name);
        profile.setAge(age);
        profile.setLogin(login);
        profile.setPassword(password);
        userService.changeUser(profile);
        return "redirect:/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegist(Model model) {
        User user = new User();
        model.addAttribute("userUp", user);
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String regist(@ModelAttribute("userUp") @Validated User user) {
        userService.registrUser(user);
        roleService.registRole(user, "USER");
        return "redirect:/mylogin";
    }

    @GetMapping(value = "/registred")
    public String forUsers() {
        return "forAuthorizingUser";
    }
}