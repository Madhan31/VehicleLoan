package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;

@Controller
public class LoanController extends HttpServlet {
    UserService userService = new UserService();
    
    @RequsetMapping("/welcome") 
    public String welcome() {
        return "logIn";
    }
    
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam("userId")String userId, @RequestParam("password")String password, HttpSession session) throws ServletException, IOException {  
        try {
            User user = userService.retrieveUser(userId);
            if(user != null) {
                if ((user.getRole().equals("admin")) && (user.getPassword().equals(password))) {
            	    session.setAttribute("userId", userId);
            	    session.setAttribute("role", "admin");
                    return new ModelAndView("admin");
                } else if ((user.getRole().equals("user")) && (user.getPassword().equals(password))) {
            	    session.setAttribute("userId", userId);
            	    session.setAttribute("role", "user");
                    return new ModelAndView("userOperation", "user", user);
                } else {
                   return new ModelAndView("logIn", "Message", "Incorrect username or password");
                }
            } else {
            	return new ModelAndView("logIn", "Message", "Incorrect username or password");
            }
        } catch (ApplicationException e) {
            return new ModelAndView("logIn", "Message", (e.getMessage().toString()));
        }
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.POST) 
    public String addUser(@ModelAttribute("User") User user, ModelMap map) throws ServletException, IOException {
        try {
            userService.addUser(user)
            map.addAttribute("Insert", "User details added successfully");
	    return "logIn";
        } catch (ApplicationException e) {
            map.addAttribute("Insert", (e.getMessage().toString()));
            return "logIn"; 
        } 
    }
    
    
    
    
