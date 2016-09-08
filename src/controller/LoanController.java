package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exception.ApplicationException;
import model.Company;
import model.EligibilityDetail;
import model.Loan;
import model.Vehicle;
import model.VehicleModel;
import model.User;
import service.CompanyService;
import service.EligibilityDetailService;
import service.LoanService;
import service.UserService;
//import util.FileUtil;
import service.VehicleService;
import service.VehicleModelService;

@Controller
public class LoanController {
	
    private UserService userService = new UserService();
    private EligibilityDetailService eligibilityDetailService = new EligibilityDetailService();
    private VehicleService vehicleService = new VehicleService();
    private VehicleModelService vehicleModelService = new VehicleModelService();
    private CompanyService companyService = new CompanyService();
    private LoanService loanService = new LoanService();
    
    @RequestMapping("/logIn") 
    public String welcome() {
        return "logIn";
    }
    
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam("userId")int userId, @RequestParam("password")String password, HttpSession session) {  
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
    	map.addAttribute("user", new User());
        return "user";
    }  
    
    @RequestMapping(value="/addUser", method = RequestMethod.POST) 
    public String addUser(@ModelAttribute("user") User user, ModelMap map) {
        try {
            userService.addUser(user);
            int userId = userService.getUserId(user.getMobileNumber());
            map.addAttribute("Message", "Your user ID is:"+userId);
	        return "logIn";
        } catch (ApplicationException e) {
            map.addAttribute("Message", (e.getMessage().toString()));
            return "logIn"; 
        } 
    }
    
    @RequestMapping("/homepage")     
    public String eligibilityDetail(ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("eligibilityDetail", new EligibilityDetail());
    	modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
    	modelMap.addAttribute("companyList", companyService.retrieveCompanies());
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
    
    @RequestMapping(value = "/loan")     
    public String loan(@ModelAttribute("loan") Loan loan, ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("loan", new Loan());
        return "loan";
    }
    
    @RequestMapping(value = "/emi", method = RequestMethod.GET)     
    public String emi(@RequestParam("loanPeriod") int loanPeriod,@RequestParam("loanAmount") int loanAmount, ModelMap modelMap) throws ApplicationException {
    	System.out.println(loanPeriod + loanAmount);
    	modelMap.addAttribute("emiDetails", loanService.getEmiDetails(loanPeriod, loanAmount));
        return "emi";
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
    private ModelAndView addEligibilityDetail(@ModelAttribute("eligibilityDetail") EligibilityDetail eligibilityDetail, BindingResult bindingResult) {
        try {
        	VehicleModel vechicleModel = vehicleModelService.getVehicleModelById(eligibilityDetail.getVehicleModel().getVehicleModelId()); 
            if (eligibilityDetailService.addEligibilityDetail(eligibilityDetail)) {
                return new ModelAndView("loan", "loanamount", loanService.calculateLoanAmount(eligibilityDetail,vechicleModel));
            } else {
                return new ModelAndView("acknowledgement", "message", "Data not inserted...");
            }            
        } catch (ApplicationException exp) {
        	//FileUtil.errorLog("Exception occured in EmployeeDao/insertEmployee()..." + exp.toString());	
            return new ModelAndView("acknowledgement", "message", exp.getMessage());           
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ModelAndView("acknowledgement", "message", e.getMessage());
        }
    }
    
    @RequestMapping("/insertVehicle")     
    public String insertVehicle(ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("insertVehicle", new Vehicle());
        return "addVehicle";
    }
    
    @RequestMapping("/addVehicle")
    public String addVehicle(@ModelAttribute("insertVehicle") Vehicle vehicle, ModelMap modelMap) throws ApplicationException {
        modelMap.addAttribute("insert", vehicleService.addVehicle(vehicle));
        return "addVehicle";
    } 
    
    @RequestMapping("/insertVehicleModel")     
    public String insertVehicleModel(ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("insertVehicleModel", new VehicleModel());
        return "addVehicleModel";
    }
    
    @RequestMapping("/addVehicleModel")
    public String addVehicleModel(@ModelAttribute("insertVehicleModel") VehicleModel vehicleModel, ModelMap modelMap) throws ApplicationException {
        modelMap.addAttribute("insert", vehicleModelService.addVehicleModel(vehicleModel));
        return "addVehicleModel";
    } 
    
    @RequestMapping("/insertCompany")     
    public String insertCompany(ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("insertCompany", new Company());
        return "addCompany";
    }
    
    @RequestMapping("/addCompany")
    public String addCompany(@ModelAttribute("insertCompany") Company company, ModelMap modelMap) throws ApplicationException {
        modelMap.addAttribute("insert", companyService.addCompany(company));
        return "addCompany";
    }
    
    @RequestMapping("/deleteCompany")     
    public String deleteCompany(ModelMap modelMap) throws ApplicationException {
        List<Company> companies = companyService.retrieveCompanies();
    	modelMap.addAttribute("companies", companies);
        return "removeCompany";
    }
    
    @RequestMapping(value = "/removeCompany", method = RequestMethod.GET)     
    public String removeCompany(@RequestParam("companyId") int companyId, ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("remove", companyService.removeCompany(companyId));
        return "removeCompany";
    } 

    @RequestMapping("/deleteVehicleModel")     
    public String deleteVehicleModel(ModelMap modelMap) throws ApplicationException {
        List<VehicleModel> vehicleModels = vehicleModelService.retrieveVehicleModels();
    	modelMap.addAttribute("vehicleModels", vehicleModels);
        return "removeVehicleModel";
    }
    
    @RequestMapping(value = "/removeVehicleModel", method = RequestMethod.GET)     
    public String removeVehicleModel(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("remove", vehicleModelService.removeVehicleModel(vehicleModelId));
        return "removeVehicleModel";
    } 
   
    @RequestMapping("/retrieveAllVehicle")     
    public String retrieveAllVehicle(ModelMap modelMap) throws ApplicationException {
        List<Vehicle> vehicles = vehicleService.retrieveVehicles();
    	modelMap.addAttribute("vehicles", vehicles);
        return "retrieveAllVehicle";
    }
    
    @RequestMapping("/retrieveAllVehicleModel")     
    public String retrieveAllVehicleModel(ModelMap modelMap) throws ApplicationException {
        List<VehicleModel> vehicleModels = vehicleModelService.retrieveVehicleModels();
    	modelMap.addAttribute("vehicleModels", vehicleModels);
        return "retrieveAllVehicleModel";
    }
    
    @RequestMapping("/retrieveAllCompany")     
    public String retrieveAllCompany(ModelMap modelMap) throws ApplicationException {
        List<Company> companies = companyService.retrieveCompanies();
    	modelMap.addAttribute("companies", companies);
        return "retrieveAllCompany";
    }
    
    @RequestMapping("/adminOperation")
    public String adminOperation(ModelMap modelMap) {   
        return "adminOperation";
    }
    
}
    
    
    
    
