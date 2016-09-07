package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exception.ApplicationException;
import model.EligibilityDetail;
//import model.User;
import service.EligibilityDetailService;
//import service.UserService;
//import util.FileUtil;
import service.VehicleService;
import service.VehicleModelService;

@Controller
public class LoanController {
   // private UserService userService = new UserService();
    private EligibilityDetailService eligibilityDetailService = new EligibilityDetailService();
    private VehicleService vehicleService = new VehicleService();
    private VehicleModelService vehicleModelService = new VehicleModelService();
    
    /*@RequestMapping("/logIn") 
    public String welcome() {
        return "logIn";
    }
    
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam("userId")String userId, @RequestParam("password")String password, HttpSession session) {  
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
            	//FileUtil.errorLog("Exception occured in EmployeeDao/insertEmployee()..." + exp.toString());	
 }
        } catch (ApplicationException e) {
            return new ModelAndView("logIn", "Message", (e.getMessage().toString()));
        }
    }
    
    @RequestMapping("/signUp")     
    public String signUp(ModelMap map) {
    	map.addAttribute("User", new User());
        return "user";
    }  
    
    @RequestMapping(value="/addUser", method = RequestMethod.POST) 
    public String addUser(@ModelAttribute("User") User user, ModelMap map) {
        try {
            userService.addUser(user);
            map.addAttribute("Insert", "User details added successfully");
	    return "logIn";
        } catch (ApplicationException e) {
            map.addAttribute("Insert", (e.getMessage().toString()));
            return "logIn"; 
        } 
    }*/
    
    @RequestMapping("/homepage")     
    public String eligibilityDetail(ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("eligibilityDetail", new EligibilityDetail());
    	modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
        return "homepage";
    } 
    
    @RequestMapping(value = "/vehicleModelView", method = RequestMethod.GET)     
    public String vehicleModelView(@RequestParam("vehicleId") int vehicleId, ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("vehicleModelList", vehicleModelService.getVehicleModelsByVehicleId(vehicleId));
        return "vehicleModelView";
    } 
    
    @RequestMapping(value = "/vehicleModelPrice", method = RequestMethod.GET)     
    public String vehicleModelPrice(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("vehicleModel", vehicleModelService.getVehicleModelById(vehicleModelId));
        return "vehicleModelPrice";
    }     
    
    /**
     * <p>
     * Gets employee details from jsp and calls service method and also display result.
     * </p>
     * 
     * @param employee
     * 		employee object contains employee details like id,name,etc.,
     * @return 
     * 		Returns success or failure message and also shows exception if any through jsp.
     */
    @RequestMapping(value = "/addeligibilitydetail", method = RequestMethod.GET)
    private ModelAndView addEligibilityDetail(@ModelAttribute("EligibilityDetail") EligibilityDetail eligibilityDetail) {
        try {
            if (eligibilityDetailService.addEligibilityDetail(eligibilityDetail)) {
                return new ModelAndView("acknowledgement", "message", "Data inserted successfully...");
            } else {
                return new ModelAndView("acknowledgement", "message", "Data not inserted...");
            }            
        } catch (ApplicationException exp) {
        	//FileUtil.errorLog("Exception occured in EmployeeDao/insertEmployee()..." + exp.toString());	
            return new ModelAndView("acknowledgement", "message", exp.getMessage());           
        } catch (Exception e) {
        	return new ModelAndView("acknowledgement", "message", e.getMessage());
        }
    }    
}
    
    
    
    
