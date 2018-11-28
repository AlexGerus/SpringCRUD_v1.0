package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.module.Role;
import project.module.User;
import project.service.RoleService;
import project.service.UserService;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model){
        model.addAttribute("userAttribute", new User());
        model.addAttribute("roleAttribute", new Role());
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("userAttribute")User user, @ModelAttribute("roleAttribute") Role role){
        userService.addUser(user);
        roleService.addRole(user, role);
        return "redirect:/list";
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") long id, Model model){
        roleService.removeRole(id);
        userService.removeUser(id);
        model.addAttribute("id", id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.GET)
    public String getEdit(@RequestParam("idChange")long id,
                          @RequestParam("nameChange")String name,
                          @RequestParam("ageChange")int age,
                          @RequestParam("loginChange")String login,
                          @RequestParam("passwordChange")String password,
                          Model model){
        model.addAttribute("idChange",id);
        model.addAttribute("nameChange",name);
        model.addAttribute("ageChange",age);
        model.addAttribute("loginChange",login);
        model.addAttribute("passwordChange",password);
        return "changeUser";
    }


    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public String changeUser(@RequestParam("idChange")long id,
                             @RequestParam("nameChange")String name,
                             @RequestParam("ageChange")int age,
                             @RequestParam("loginChange")String login,
                             @RequestParam("passwordChange")String password,
                             @ModelAttribute("changeAttribute")User profile){
        profile.setId(id);
        profile.setName(name);
        profile.setAge(age);
        profile.setLogin(login);
        profile.setPassword(password);
        userService.changeUser(profile);
        return "redirect:/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(Model model, HttpSession session) throws IOException{
        if(session.getAttribute("userRole").equals("Admin")){
            List<User> list = userService.listUser();
            model.addAttribute("list", list);
            return "list";
        }
        else{
            return "forbidden";
        }
    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String getRegist(Model model){
        model.addAttribute("registAttribute", new User());
        return "registration";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String registUser(@ModelAttribute("registAttribute")User user){
        userService.registrUser(user);
        roleService.registRole(user, "user");
        return "redirect:/registred";
    }

    @RequestMapping(value = "/registred", method = RequestMethod.GET)
    public String registred(){
        return "registred";
    }

    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String enter(@RequestParam("login")String login,
                        @RequestParam("password")String password,
                        Model model, HttpSession session){
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        User profile = userService.getUserLogin(login);
        Role role = roleService.findRole(profile.getId());
        if(profile.getPassword()!=null && profile.getLogin()!=null && profile.getPassword().equalsIgnoreCase(password)){
            if(role.getNameRole().equalsIgnoreCase("user")){
                session.setAttribute("userRole", role.getNameRole());
                return "forAuthorizingUser";
            }
            else if(role.getNameRole().equalsIgnoreCase("admin")){
                session.setAttribute("userRole", role.getNameRole());
                return "redirect:/list";
            }
            else return "redirect:/index";
        }
        else return "redirect:/index";
    }
}
