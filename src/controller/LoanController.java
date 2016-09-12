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
import model.Address;
import model.Company;
import model.EligibilityDetail;
import model.Loan;
import model.LoanDetail;
import model.Payment;
import model.Vehicle;
import model.VehicleModel;
import model.User;
import service.AddressService;
import service.CompanyService;
import service.EligibilityDetailService;
import service.LoanDetailService;
import service.LoanService;
import service.PaymentService;
import service.UserService;
import service.VehicleService;
import service.VehicleModelService;

/**
 * <p>
 * public LoanController class which has methods for adding, removing, etc., loan details and payment detail for an logged user.
 * This class gets input like user name, contact, etc., from user through jsp page and calls corresponding loan service methods to add or update particular user details. 
 * And it calls jsp pages for success or failure messages and also for exceptions.
 * </p>
 * 
 * @author Madhan
 * 
 * @since 2016-08-27
 */
@Controller
public class LoanController {
	
    private UserService userService = new UserService();
    private EligibilityDetailService eligibilityDetailService = new EligibilityDetailService();
    private VehicleService vehicleService = new VehicleService();
    private VehicleModelService vehicleModelService = new VehicleModelService();
    private CompanyService companyService = new CompanyService();
    private LoanService loanService = new LoanService();
    private PaymentService paymentService = new PaymentService();
    private LoanDetailService loanDetailService = new LoanDetailService();
    private AddressService addressService = new AddressService();
    
	/**
	 * public String loginpage() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/logIn") 
    public String welcome() {
        return "logIn";
    }
    
    /**
     * public ModelAndView logIn method gets user id and password from user and transfer to corresponds jsp file.
     * @param userId
     * 		Contains unique id of an user.
     * @param password
     * 		Contains password of an user.
     * @return
     * 		Finally to it's returns a jsp page.
     */
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam("userId")int userId, @RequestParam("password")String password, HttpSession session) {  
        try {
            User user = userService.retrieveUser(userId);
            if(user != null) {
                if (((user.getRole().getRoleName()).equals("admin")) && (user.getPassword().equals(password))) {
            	    session.setAttribute("userId", userId);
            	    session.setAttribute("role", "admin");
                    return new ModelAndView("adminOperation");
                } else if (((user.getRole().getRoleName()).equals("user")) && (user.getPassword().equals(password))) {
            	    session.setAttribute("userId", userId);
            	    session.setAttribute("role", "user");
                    return new ModelAndView("userOperation");
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
    
	/**
	 * public String signUp() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */     
    @RequestMapping("/signUp")     
    public String signUp(ModelMap map) {
    	map.addAttribute("user", new User());
        return "user";
    }  
    
    /**
     * public String addUser method gets user details through spring form and transfer to service method. 
     * @param user
     * 		It contains user details.
     * @param map
     * 		It's like a hashmap used to store key and value
     * @return
     * 		Returns to the jsp page.
     */
    @RequestMapping(value="/addUser", method = RequestMethod.POST) 
    public String addUser(@ModelAttribute("user") User user, ModelMap map) {
        try {
            userService.addUser(user);
            map.addAttribute("Message", "Your user ID is:"+user.getUserId());
            if(user.getRole().getRoleId() == 2){
	            return "admin";
            }
            return "logIn";            
        } catch (ApplicationException e) {
            map.addAttribute("Message", (e.getMessage().toString()));
            return "logIn"; 
        } 
    }
    
	/**
	 * public ModelAndView eligibilityDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/homePage")     
    public ModelAndView eligibilityDetail(ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("eligibilityDetail", new EligibilityDetail());
    		modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
    		modelMap.addAttribute("companyList", companyService.retrieveCompanies());
    		return new ModelAndView("homepage", "message", "Added Successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "Message", exp.toString());
    	}
    } 
    
	/**
	 * public ModelAndView vehicleModelView() gets vehicle id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/vehicleModelView", method = RequestMethod.GET)     
    public ModelAndView vehicleModelView(@RequestParam("vehicleId") int vehicleId, ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("vehicleModelList", vehicleModelService.getVehicleModelsByVehicleId(vehicleId));
    		return new ModelAndView("vehicleModelView", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}
    } 
    
	/**
	 * public ModelAndView vehicleModelPrice() gets vehicle Model Id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/vehicleModelPrice", method = RequestMethod.GET)     
    public ModelAndView vehicleModelPrice(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("vehicleModel", vehicleModelService.getVehicleModelById(vehicleModelId));
    		return new ModelAndView("vehicleModelPrice", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}    	
    }
    
	/**
	 * public String emi() gets loanperiod and loan amount through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/emi", method = RequestMethod.GET)     
    public String emi(@RequestParam("loanPeriod") int loanPeriod,@RequestParam("loanAmount") int loanAmount, ModelMap modelMap) throws ApplicationException {
    	modelMap.addAttribute("emi", loanService.getEmiDetails(loanPeriod, loanAmount));
    	modelMap.addAttribute("processingFees", loanService.getProcessingFees(loanPeriod, loanAmount));
    	modelMap.addAttribute("documentationCharges", loanService.getDocumentationCharges(loanPeriod, loanAmount));
        return "emi";
    }    
    
    
    /**
     * public ModelAndView addEligibilityDetail method gets eligibility details from user and transfer to corresponds jsp file.
     * @param eligibilityDetail
     * 		Contains eligibility detail of an user.
     * @param modelMap
     * 		It's like a hashmap used to store key and value.
     * @return
     * 		Returns to jsp file to display the output.
     */
    @RequestMapping(value = "/addeligibilitydetail", method = RequestMethod.GET)
    public ModelAndView addEligibilityDetail(@ModelAttribute("eligibilityDetail") EligibilityDetail eligibilityDetail, BindingResult bindingResult, ModelMap modelMap) {
        try {
        	VehicleModel vechicleModel = vehicleModelService.getVehicleModelById(eligibilityDetail.getVehicleModel().getVehicleModelId()); 
            if (eligibilityDetailService.addEligibilityDetail(eligibilityDetail)) {
            	System.out.println(eligibilityDetail.getId());
            	modelMap.addAttribute("eligibilityDetailId", eligibilityDetail.getId());
            	modelMap.addAttribute("loan", new Loan());
                return new ModelAndView("loan", "loanamount", loanService.calculateLoanAmount(eligibilityDetail,vechicleModel));
            } else {
                return new ModelAndView("acknowledgement", "message", "Data not inserted...");
            }            
        } catch (ApplicationException exp) {
            return new ModelAndView("acknowledgement", "message", exp.getMessage());           
        } catch (Exception e) {
        	return new ModelAndView("acknowledgement", "message", e.getMessage());
        }
    }
    
    /**
     * public ModelAndView addLoanDetail method gets loan details from user and transfer to corresponds jsp file.
     * @param loan
     * 		It contains loan details of an user.
     * @param modelMap
     * 		It's like a hashmap used to store key and value.
     * @return
     * 		Returns to the jsp file for output.
     */
    @RequestMapping(value = "/addloandetail", method = RequestMethod.GET)
    private ModelAndView addLoanDetail(@ModelAttribute("loan") Loan loan, BindingResult bindingResult, ModelMap modelMap) {
        try {
        	loanService.addLoan(loan);
        	modelMap.addAttribute("address", new Address());
        	return new ModelAndView("address", "loan", loan);
        } catch (ApplicationException exp) {;	
            return new ModelAndView("acknowledgement", "message", exp.getMessage());
        } catch (Exception e) {
        	return new ModelAndView("acknowledgement", "message", e.getMessage());
        }
    }  
    
    /**
     * public ModelAndView addAddress method gets address from user and transfer to corresponds jsp file.
     * @param address
     * 		It contains user address.
     * @param modelMap
     * 		It's like a hashmap used to store key and value.
     * @return
     * 		Returns to jsp file.
     */
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    private ModelAndView addAddress(@ModelAttribute("address") Address address, BindingResult bindingResult, ModelMap modelMap) {
        try {
        	addressService.addAddress(address);
        	return new ModelAndView("acknowledgement", "message", "Loan applied successfully we will contact you soon");
        } catch (ApplicationException exp) {
            return new ModelAndView("acknowledgement", "message", exp.getMessage());
        } catch (Exception e) {
        	return new ModelAndView("acknowledgement", "message", e.getMessage());
        }
    }      
    
	/**
	 * public String vehicleOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/vehicleOperation") 
    public String vehicleOperation() {
    	return "vehicleOperation";
    }
    
	/**
	 * public String vehicleModelOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/vehicleModelOperation") 
    public String vehicleModelOperation() {
    	return "vehicleModelOperation";
    }
    
	/**
	 * public String companyOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/companyOperation") 
    public String companyOperation() {
    	return "companyOperation";
    }

	/**
	 * public String insertVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/insertVehicle")     
    public String insertVehicle(ModelMap modelMap) {
    	modelMap.addAttribute("insertVehicle", new Vehicle());
        return "addVehicle";
    }
    
	/**
	 * public ModelAndView addVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addVehicle")
    public ModelAndView addVehicle(@ModelAttribute("insertVehicle") Vehicle vehicle, ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insert", vehicleService.addVehicle(vehicle));
    		return new ModelAndView("addVehicle", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    } 
    
	/**
	 * public ModelAndView insertVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/insertVehicleModel")     
    public ModelAndView insertVehicleModel(ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("insertVehicleModel", new VehicleModel());
        	modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
    		return new ModelAndView("addVehicleModel", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    }
    
	/**
	 * public ModelAndView addVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addVehicleModel")
    public ModelAndView addVehicleModel(@ModelAttribute("insertVehicleModel") VehicleModel vehicleModel, ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insert", vehicleModelService.addVehicleModel(vehicleModel));
    		return new ModelAndView("addVehicleModel", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    } 
    
	/**
	 * public String insertCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/insertCompany")     
    public String insertCompany(ModelMap modelMap) {
    	modelMap.addAttribute("insertCompany", new Company());
        return "addCompany";
    }
    
	/**
	 * public ModelAndView addCompany() gets company details through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addCompany")
    public ModelAndView addCompany(@ModelAttribute("insertCompany") Company company, ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insert", companyService.addCompany(company));
    		return new ModelAndView("addCompany", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}    	
    }
    
	/**
	 * public ModelAndView deleteCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/deleteCompany")     
    public ModelAndView deleteCompany(ModelMap modelMap) {
    	try {
            List<Company> companies = companyService.retrieveCompanies();
        	modelMap.addAttribute("companies", companies);    		
    		return new ModelAndView("removeCompany", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}    	
    }
    
	/**
	 * public ModelAndView removeCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeCompany", method = RequestMethod.GET)     
    public ModelAndView removeCompany(@RequestParam("companyId") int companyId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("remove", companyService.removeCompany(companyId));  		
    		return new ModelAndView("removeCompany", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    } 

	/**
	 * public ModelAndView deleteVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/deleteVehicleModel")     
    public ModelAndView deleteVehicleModel(ModelMap modelMap) {
    	try {
            List<VehicleModel> vehicleModels = vehicleModelService.retrieveVehicleModels();
        	modelMap.addAttribute("vehicleModels", vehicleModels);  		
    		return new ModelAndView("removeVehicleModel", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    }
    
	/**
	 * public ModelAndView removeVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeVehicleModel", method = RequestMethod.GET)     
    public ModelAndView removeVehicleModel(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("remove", vehicleModelService.removeVehicleModel(vehicleModelId)); 		
    		return new ModelAndView("removeVehicleModel", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    } 
   
	/**
	 * public ModelAndView retrieveAllVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/retrieveAllVehicle")     
    public ModelAndView retrieveAllVehicle(ModelMap modelMap) {
    	try {
            List<Vehicle> vehicles = vehicleService.retrieveVehicles();
        	modelMap.addAttribute("vehicles", vehicles);
        	return new ModelAndView("retrieveAllVehicle", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    }
    
	/**
	 * public ModelAndView retrieveAllVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveAllVehicleModel")     
    public ModelAndView retrieveAllVehicleModel(ModelMap modelMap) {
    	try {
            List<VehicleModel> vehicleModels = vehicleModelService.retrieveVehicleModels();
        	modelMap.addAttribute("vehicleModels", vehicleModels);
        	return new ModelAndView("retrieveAllVehicleModel", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    }
    
	/**
	 * public ModelAndView retrieveAllCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveAllCompany")     
    public ModelAndView retrieveAllCompany(ModelMap modelMap) {
    	try {
    		List<Company> companies = companyService.retrieveCompanies();
        	modelMap.addAttribute("companies", companies);
        	return new ModelAndView("retrieveAllCompany", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}    	
    }
    
	/**
	 * public String loanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/loanDetail") 
    public String loanDetail() {
    	return "loanDetail";
    }
    
	/**
	 * public ModelAndView payment() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/payment")
    public ModelAndView payment(@RequestParam("userId") int userId, ModelMap modelMap) {
    	try {
        	List<Loan> loans = loanService.retrieveLoansByUserId(userId);
        	modelMap.addAttribute("loans",loans);
        	modelMap.addAttribute("userId",userId);
        	modelMap.addAttribute("payment", new Payment());
        	return new ModelAndView("payment", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    }
    
	/**
	 * public ModelAndView paymentConfirm() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/paymentConfirm") 
    public ModelAndView paymentConfirm(@ModelAttribute("payment") Payment payment, ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("insert", paymentService.addPayment(payment));
        	return new ModelAndView("loanDetail", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}     	
    } 
    
	/**
	 * public ModelAndView retrieveUserLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserLoanDetail")
    public ModelAndView retrieveUserLoanDetail(ModelMap modelMap, HttpSession session) {
    	try {
    		List<LoanDetail> loanDetails = loanDetailService.retrieveLoanDetailByUserId((int) session.getAttribute("userId"));
        	modelMap.addAttribute("loanDetails", loanDetails);
        	return new ModelAndView("retrieveUserLoanDetail", "message", "Added successfully");
    	} catch (ApplicationException exp) {
    		return new ModelAndView("acknowledgement", "message", exp.toString());
    	}      	
    }
    
	/**
	 * public String admin() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/admin")     
    public String admin(ModelMap map) {
    	map.addAttribute("user", new User());
        return "admin";
    } 
    
	/**
	 * public String adminOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/adminOperation")
    public String adminOperation(ModelMap modelMap) {   
        return "adminOperation";
    }
    
	/**
	 * public String logout() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/logout")
    public String logout() {   
        return "logIn";
    }
}
    
    
    
    