package com.i2i.vehicleloan.controller;

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

import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Address;
import com.i2i.vehicleloan.model.Company;
import com.i2i.vehicleloan.model.EligibilityDetail;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.LoanDetail;
import com.i2i.vehicleloan.model.Payment;
import com.i2i.vehicleloan.model.User;
import com.i2i.vehicleloan.model.Vehicle;
import com.i2i.vehicleloan.model.VehicleModel;
import com.i2i.vehicleloan.service.AddressService;
import com.i2i.vehicleloan.service.CompanyService;
import com.i2i.vehicleloan.service.EligibilityDetailService;
import com.i2i.vehicleloan.service.LoanDetailService;
import com.i2i.vehicleloan.service.LoanService;
import com.i2i.vehicleloan.service.PaymentService;
import com.i2i.vehicleloan.service.UserService;
import com.i2i.vehicleloan.service.VehicleModelService;
import com.i2i.vehicleloan.service.VehicleService;

/**
 * <p>
 * LoanController class which has methods for adding, removing, etc., loan details and payment detail for an logged user.
 * This class gets input like user name, contact, etc., from user through jsp page and calls corresponding loan service methods to add or update particular user details. 
 * And it calls jsp pages for success or failure messages and also for exceptions.
 * </p>
 * 
 * @author Madhan
 * 
 * @since 2016-09-06
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
     * ModelAndView logIn method gets user id and password from user and transfer to corresponds jsp file.
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
                   return new ModelAndView("logIn", "message", "Incorrect username or password");
                }
            } else {
            	return new ModelAndView("logIn", "message", "Incorrect username or password");
            }
        } catch (DatabaseException exp) {
            return new ModelAndView("logIn", "message", (exp.getMessage().toString()));
        } catch (ConfigurationException exp) {
        	return new ModelAndView("logIn", "message", (exp.getMessage().toString()));
        }
    }
    
	/**
	 * String loginpage() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/logIn") 
    public String loginForm() {
        return "logIn";
    }    
    
    /**
	 * String contact() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/contact") 
    public String contact() {
        return "contact";
    }
    
    /**
	 * String about() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/about") 
    public String about() {
        return "about";
    }
    
    /**
     * String index() redirects to jsp page when corresponding url is called as mapped below the method definition.
     * @return
     * 		Returns jsp file name.
     */
    @RequestMapping("/index")	
	private String index() {
    	return "index";
    }     
    
	/**
	 * String signUp() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */     
    @RequestMapping("/signUp")     
    public String signUp(ModelMap map) {
    	map.addAttribute("user", new User());
        return "signUp";
    }  
    
    /**
     * String addUser method gets user details through spring form and transfer to service method. 
     * @param user
     * 		It contains user details.
     * @param map
     * 		It's like a hashmap used to store key and value
     * @return
     * 		Returns to the jsp page.
     */
    @RequestMapping(value="/addUser", method = RequestMethod.POST) 
    public String addUser(@ModelAttribute("user") User user, ModelMap modelMap) {
        try {
            userService.addUser(user);
            modelMap.addAttribute("message", "Your user ID is:"+user.getUserId());
            if (user.getRole().getRoleId() == 2) {
	            return "admin";
            }
            return "logIn";            
        } catch (DatabaseException exp) {
        	modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "logIn"; 
        } catch (ConfigurationException exp) {
        	modelMap.addAttribute("message", (exp.getMessage().toString()));
        	return "logIn";
        }
    }
    
	/**
	 * String eligibilityDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */        
    @RequestMapping("/homePage")     
    public String eligibilityDetail(ModelMap modelMap, HttpSession session) {
    	try {
    	    if (null != session.getAttribute("userId")) {
    	        modelMap.addAttribute("eligibilityDetail", new EligibilityDetail());
    	        modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
    	        modelMap.addAttribute("companyList", companyService.retrieveCompanies());    		
    		    modelMap.addAttribute("loanDetail", loanDetailService.retrieveLoanDetailByUserId((int)session.getAttribute("userId")));
    		    return "homePage";
    		} else {
    		    return "logIn";
    		}
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "homePage";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "homePage";
        }
    }
    
	/**
	 * ModelAndView vehicleModelView() gets vehicle id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/vehicleModelView", method = RequestMethod.GET)     
    public String vehicleModelView(@RequestParam("vehicleId") int vehicleId, ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("vehicleModelList", vehicleModelService.getVehicleModelsByVehicleId(vehicleId));
    		return "vehicleModelView";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "homePage";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "homePage";
        }
    } 
    
	/**
	 * ModelAndView vehicleModelPrice() gets vehicle Model Id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/vehicleModelPrice", method = RequestMethod.GET)     
    public String vehicleModelPrice(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("vehicleModel", vehicleModelService.getVehicleModelById(vehicleModelId));
    		return "vehicleModelPrice";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "homePage";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "homePage";
        }
    }
    
	/**
	 * String emi() gets loanperiod and loan amount through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/emi", method = RequestMethod.GET)     
    public String emi(@RequestParam("loanPeriod") int loanPeriod,@RequestParam("loanAmount") int loanAmount, ModelMap modelMap) {
    	modelMap.addAttribute("emi", loanService.getEmiDetails(loanPeriod, loanAmount));
    	modelMap.addAttribute("processingFees", loanService.getProcessingFees(loanPeriod, loanAmount));
    	modelMap.addAttribute("documentationCharges", loanService.getDocumentationCharges(loanPeriod, loanAmount));
        return "emi";
    }    
    
    
    /**
     * ModelAndView addEligibilityDetail method gets eligibility details from user and transfer to corresponds jsp file.
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
            System.out.println(eligibilityDetail.getCompany().getCompanyName());
        	VehicleModel vechicleModel = vehicleModelService.getVehicleModelById(eligibilityDetail.getVehicleModel().getVehicleModelId()); 
            if (eligibilityDetailService.addEligibilityDetail(eligibilityDetail)) {                
            	modelMap.addAttribute("eligibilityDetailId", eligibilityDetail.getId());
            	modelMap.addAttribute("loan", new Loan());
                return new ModelAndView("loan", "loanamount", loanService.calculateLoanAmount(eligibilityDetail,vechicleModel));
            } else {
                return new ModelAndView("homePage", "message", "Data not inserted...");
            }            
        } catch (DatabaseException exp) {
            return new ModelAndView("homePage", "message", exp.getMessage());           
        } catch (ConfigurationException exp) {
        	return new ModelAndView("homePage", "message", exp.getMessage());
        }
    }
    
    /**
     * ModelAndView addLoanDetail method gets loan details from user and transfer to corresponds jsp file.
     * @param loan
     * 		It contains loan details of an user.
     * @param modelMap
     * 		It's like a hashmap used to store key and value.
     * @return
     * 		Returns to the jsp file for output.
     */
    @RequestMapping(value = "/addloandetail", method = RequestMethod.GET)
    public String addLoanDetail(@ModelAttribute("loan") Loan loan, BindingResult bindingResult, ModelMap modelMap) {
        try {
        	loanService.addLoan(loan);
        	loanDetailService.addLoanDetail(new LoanDetail(loan.getLoanAmount(), loan.getLoanPeriod(), loan.getUser()));
        	modelMap.addAttribute("address", new Address()); 
        	return "address";
        } catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "loan";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "loan";
        }
    }  
    
    /**
     * ModelAndView addAddress method gets address from user and transfer to corresponds jsp file.
     * @param address
     * 		It contains user address detail.
     * @param modelMap
     * 		It's like a hashmap used to store key and value.
     * @return
     * 		Returns to jsp file.
     */
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ModelAndView addAddress(@ModelAttribute("address") Address address, BindingResult bindingResult, ModelMap modelMap) {
        try {
        	addressService.addAddress(address);
        	return new ModelAndView("address", "message", "Loan applied successfully we will contact you soon");
        } catch (DatabaseException exp) {
            return new ModelAndView("address", "message", (exp.getMessage().toString()));
        } catch (ConfigurationException exp) {
        	return new ModelAndView("address", "message", (exp.getMessage().toString()));
        }
    }      
    
	/**
	 * String vehicleOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/vehicleOperation") 
    public String vehicleOperation() {
    	return "vehicleOperation";
    }
    
	/**
	 * String vehicleModelOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/vehicleModelOperation") 
    public String vehicleModelOperation() {
    	return "vehicleModelOperation";
    }
    
	/**
	 * String companyOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/companyOperation") 
    public String companyOperation() {
    	return "companyOperation";
    }

	/**
	 * String insertVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/insertVehicle")     
    public String insertVehicle(ModelMap modelMap) {
        modelMap.addAttribute("insertVehicle", new Vehicle());
        return "addVehicle";
    }
    
	/**
	 * ModelAndView addVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addVehicle")
    public ModelAndView addVehicle(@ModelAttribute("insertVehicle") Vehicle vehicle, ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insert", vehicleService.addVehicle(vehicle));
    		return new ModelAndView("addVehicle", "message", "Added successfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("addVehicle", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
        	return new ModelAndView("addVehicle", "message", (exp.getMessage().toString()));
        }   	
    } 
    
	/**
	 * ModelAndView insertVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/insertVehicleModel")     
    public String insertVehicleModel(ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("insertVehicleModel", new VehicleModel());
        	modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
    		return "addVehicleModel";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
        }    	
    }
    
	/**
	 * ModelAndView addVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addVehicleModel")
    public ModelAndView addVehicleModel(@ModelAttribute("insertVehicleModel") VehicleModel vehicleModel, ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insert", vehicleModelService.addVehicleModel(vehicleModel));
    		return new ModelAndView("addVehicleModel", "message", "Added successfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("addVehicleModel", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
    		return new ModelAndView("addVehicleModel", "message", (exp.getMessage().toString()));
    	}       	
    } 
    
	/**
	 * String insertCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/insertCompany")     
    public String insertCompany(ModelMap modelMap) {
    	modelMap.addAttribute("insertCompany", new Company());
        return "addCompany";
    }
    
	/**
	 * ModelAndView addCompany() gets company details through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addCompany")
    public ModelAndView addCompany(@ModelAttribute("insertCompany") Company company, ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insert", companyService.addCompany(company));
    		return new ModelAndView("addCompany", "message", "Added successfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("addCompany", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
    		return new ModelAndView("addCompany", "message", (exp.getMessage().toString()));
    	}     	
    }
    
	/**
	 * ModelAndView deleteCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/deleteCompany")     
    public String deleteCompany(ModelMap modelMap) {
    	try {
            List<Company> companies = companyService.retrieveCompanies();
        	modelMap.addAttribute("companies", companies);    		
    		return "removeCompany";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
        }       	 	
    }
    
	/**
	 * ModelAndView removeCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeCompany", method = RequestMethod.GET)     
    public ModelAndView removeCompany(@RequestParam("companyId") int companyId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("remove", companyService.removeCompany(companyId));  		
    		return new ModelAndView("removeCompany", "message", "Deleted successfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("removeCompany", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
    		return new ModelAndView("removeCompany", "message", (exp.getMessage().toString()));
    	}       	
    } 
    
	/**
	 * ModelAndView deleteVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */   
    @RequestMapping("/deleteVehicle")     
    public String deleteVehicle(ModelMap modelMap) {
    	try {
            List<Vehicle> vehicles = vehicleService.retrieveVehicles();
        	modelMap.addAttribute("vehicles", vehicles);    		
    		return "removeVehicle";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleOperation";
        }       	 	
    }
    
	/**
	 * ModelAndView removeVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeVehicle", method = RequestMethod.GET)     
    public String removeVehicle(@RequestParam("vehicleId") int vehicleId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("message", vehicleService.removeVehicle(vehicleId));  		
    		return "removeVehicle";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "removeVehicle";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "removeVehicle";
        }      	
    } 
    
	/**
	 * ModelAndView deleteVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/deleteVehicleModel")     
    public String deleteVehicleModel(ModelMap modelMap) {
    	try {
            List<VehicleModel> vehicleModels = vehicleModelService.retrieveVehicleModels();
        	modelMap.addAttribute("vehicleModels", vehicleModels);  		
    		return "removeVehicleModel";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
        }      	
    }
    
	/**
	 * ModelAndView removeVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeVehicleModel", method = RequestMethod.GET)     
    public String removeVehicleModel(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("message", vehicleModelService.removeVehicleModel(vehicleModelId)); 		
    		return "removeVehicleModel";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
        }      	
    } 
   
	/**
	 * ModelAndView retrieveAllVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/retrieveAllVehicle")     
    public String retrieveAllVehicle(ModelMap modelMap) {
    	try {
            List<Vehicle> vehicles = vehicleService.retrieveVehicles();
        	modelMap.addAttribute("vehicles", vehicles);
        	return "retrieveAllVehicle";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleOperation";
        }        	
    }
    
	/**
	 * ModelAndView retrieveAllVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveAllVehicleModel")     
    public String retrieveAllVehicleModel(ModelMap modelMap) {
    	try {
            List<VehicleModel> vehicleModels = vehicleModelService.retrieveVehicleModels();
        	modelMap.addAttribute("vehicleModels", vehicleModels);
        	return "retrieveAllVehicleModel";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleModelOperation";
        }            	
    }
    
	/**
	 * ModelAndView retrieveAllCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveAllCompany")     
    public String retrieveAllCompany(ModelMap modelMap) {
    	try {
    		List<Company> companies = companyService.retrieveCompanies();
        	modelMap.addAttribute("companies", companies);
        	return "retrieveAllCompany";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "companyOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "companyOperation";
        }        	
    }
    
	/**
	 * String loanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/loanDetail") 
    public String loanDetail() {
    	return "loanDetail";
    }
    
	/**
	 * ModelAndView payment() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/payment")
    public String payment(@RequestParam("userId") int userId, ModelMap modelMap) {
    	try {
        	List<Loan> loans = loanService.retrieveLoansByUserId(userId);
        	modelMap.addAttribute("loans",loans);
        	modelMap.addAttribute("userId",userId);
        	modelMap.addAttribute("payment", new Payment());
        	return "payment";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "loanDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "loanDetail";
        }      	
    }
    
	/**
	 * ModelAndView paymentConfirm() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/paymentConfirm") 
    public ModelAndView paymentConfirm(@ModelAttribute("payment") Payment payment, ModelMap modelMap) {
    	try {
    		modelMap.addAttribute("insert", paymentService.addPayment(payment));
        	return new ModelAndView("loanDetail", "message", "Paided Sucessfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("loanDetail", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
    		return new ModelAndView("loanDetail", "message", (exp.getMessage().toString()));
    	}     	
    } 
    
	/**
	 * String retrieveUserLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserLoanDetail")
    public String retrieveUserLoanDetail(ModelMap modelMap, HttpSession session) {
    	try {
    	    if (null != session.getAttribute("userId")) {
    	        modelMap.addAttribute("loanDetails", loanService.retrieveLoansByUserId((int) session.getAttribute("userId")));
    	        return "retrieveLoanDetail";
    	    } 
    	    return "logIn";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "adminOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "adminOperation";
        }    	
    }   
    
    /**
	 * String retrieveUserDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserDetail")
    public String retrieveUserDetail(ModelMap modelMap, HttpSession session) {
    	try {
    	    if (null != session.getAttribute("userId")) {
    	        modelMap.addAttribute("loanDetails", loanService.retrieveLoansByUserId((int) session.getAttribute("userId")));
    	        return "retrieveUserDetail";
    	    } 
    	    return "logIn";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "userOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "userOperation";
        }    	
    }   
    
	/**
	 * String retrieveLoanBalance() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveLoanBalance")
    public String retrieveUserLoanBalance(@RequestParam("loanId") int loanId, ModelMap modelMap) {    	
    	try {        	
        	modelMap.addAttribute("loanBalance", loanDetailService.retrieveLoanDetailByLoanId(loanId));
        	return "retrieveLoanBalance";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveLoanDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveLoanDetail";
        }      	
    }    
    
    /**
	 * String retrieveUserLoanBalance() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserLoanBalanceDetail")
    public String retrieveUserLoanBalanceDetail(@RequestParam("loanId") int loanId, ModelMap modelMap) {    	
    	try {        	
        	modelMap.addAttribute("loanBalance", loanDetailService.retrieveLoanDetailByLoanId(loanId));
        	return "retrieveUserLoanBalance";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUserDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUserDetail";
        }      	
    }
    
	/**
	 * String retrievePaymentDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrievePaymentDetail")
    public String retrievePaymentDetail(@RequestParam("loanId") int loanId, ModelMap modelMap, HttpSession session) {
    	try {
        	modelMap.addAttribute("paymentDetails", paymentService.retrievePaymentsByLoanId(loanId));        	
        	return "retrievePaymentDetail";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveLoanDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveLoanDetail";
        }       	
    }  
    
    /**
	 * String retrieveUserPaymentDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserPaymentDetail")
    public String retrieveUserPaymentDetail(@RequestParam("loanId") int loanId, ModelMap modelMap, HttpSession session) {
    	try {
        	modelMap.addAttribute("paymentDetails", paymentService.retrievePaymentsByLoanId(loanId));        	
        	return "retrieveUserPaymentDetail";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUserDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUserDetail";
        }       	
    }  
    
	/**
	 * ModelAndView retrieveLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveLoanDetail")
    public String retrieveLoanDetail(@RequestParam("userId") int userId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("loanDetails", loanService.retrieveLoansByUserId(userId));        	
        	return "retrieveLoanDetail";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "userOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "userOperation";
        }      	
    }    
    
	/**
	 * String retrieveUserLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/usersDetail")
    public String retrieveAllUsers(ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("usersDetail", userService.retrieveAllUsers());        	
        	return "retrieveUsersDetail";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "adminOperation";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "adminOperation";
        }     	
    }    
    
	/**
	 * String retrieveUserAddress() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserAddress")
    public String retrieveUserAddress(@RequestParam("userId") int userId, ModelMap modelMap) {    	
    	try {        	
        	modelMap.addAttribute("userAddress", addressService.retrieveAddressByUserId(userId));
        	return "retrieveUserAddress";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUsersDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUsersDetail";
        }      	
    }    
    
	/**
	 * String retrieveEligibilityDetailByUserId() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserEligibilityDetail")
    public String retrieveEligibilityDetailsByUserId(@RequestParam("userId") int userId, ModelMap modelMap) {
    	try {
        	modelMap.addAttribute("eligibilityDetails", eligibilityDetailService.retrieveEligibilityDetailsByUserId(userId));        	
        	return "retrieveEligibilityDetail";
    	} catch (DatabaseException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUsersDetail";
    	} catch (ConfigurationException exp) {
    		modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "retrieveUsersDetail";
        }       	
    }    
    
	/**
	 * String admin() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/admin")     
    public String admin(ModelMap map) {
    	map.addAttribute("user", new User());
        return "admin";
    } 
    
	/**
	 * String adminOperation() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/adminOperation")
    public String adminOperation() {   
        return "adminOperation";
    }
    
    /**
     * String userOperation() redirects to jsp page when corresponding url is called as mapped below
     * @return
     *     Returns jsp file name.
     */
    @RequestMapping("/userOperation")
    public String userOperation() {   
        return "userOperation";
    }  
    
	/**
	 * String logout() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/logout")
    public String logout(HttpSession session) {  
        if (null != session.getAttribute("role")) {
            session.invalidate();
        }    	
        return "logIn";
    }
}
    
       
    
    
