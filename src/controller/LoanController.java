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

import exception.ConfigurationException;
import exception.DatabaseException;
import model.Address;
import model.Company;
import model.EligibilityDetail;
import model.Loan;
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
    public String addUser(@ModelAttribute("user") User user, ModelMap modelMap) {
        try {
            userService.addUser(user);
            modelMap.addAttribute("message", "Your user ID is:"+user.getUserId());
            if(user.getRole().getRoleId() == 2){
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
    		return new ModelAndView("homePage", "message", "Eligibility Detail Added Successfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("homePage", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
        	return new ModelAndView("homePage", "message", (exp.getMessage().toString()));
        }
    } 
    
	/**
	 * public ModelAndView vehicleModelView() gets vehicle id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView vehicleModelPrice() gets vehicle Model Id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public String emi() gets loanperiod and loan amount through jsp and redirects to jsp page when corresponding url is called as mapped below. 
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
                return new ModelAndView("homePage", "message", "Data not inserted...");
            }            
        } catch (DatabaseException exp) {
            return new ModelAndView("homePage", "message", (exp.getMessage().toString()));           
        } catch (ConfigurationException exp) {
        	return new ModelAndView("homePage", "message", (exp.getMessage().toString()));
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
    private String addLoanDetail(@ModelAttribute("loan") Loan loan, BindingResult bindingResult, ModelMap modelMap) {
        try {
        	loanService.addLoan(loan);
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
        	return new ModelAndView("address", "message", "Loan applied successfully we will contact you soon");
        } catch (DatabaseException exp) {
            return new ModelAndView("address", "message", (exp.getMessage().toString()));
        } catch (ConfigurationException exp) {
        	return new ModelAndView("address", "message", (exp.getMessage().toString()));
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
    	} catch (DatabaseException exp) {
    		return new ModelAndView("addVehicle", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
        	return new ModelAndView("addVehicle", "message", (exp.getMessage().toString()));
        }   	
    } 
    
	/**
	 * public ModelAndView insertVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView addVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
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
    	} catch (DatabaseException exp) {
    		return new ModelAndView("addCompany", "message", (exp.getMessage().toString()));
    	} catch (ConfigurationException exp) {
    		return new ModelAndView("addCompany", "message", (exp.getMessage().toString()));
    	}     	
    }
    
	/**
	 * public ModelAndView deleteCompany() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView removeCompany() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView removeCompany() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView deleteVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView removeVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView retrieveAllVehicle() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView retrieveAllVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView retrieveAllCompany() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView paymentConfirm() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public String retrieveUserLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */      
    @RequestMapping("/retrieveUserLoanDetail")
    public String retrieveUserLoanDetail(ModelMap modelMap, HttpSession session) {
    	try {
    		modelMap.addAttribute("loanDetails", loanService.retrieveLoansByUserId((int) session.getAttribute("userId")));
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
	 * public String retrieveLoanBalance() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public String retrievePaymentDetail() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public ModelAndView retrieveLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public String retrieveUserLoanDetail() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public String retrieveUserAddress() redirects to jsp page when corresponding url is called as mapped below. 
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
	 * public String retrieveEligibilityDetailByUserId() redirects to jsp page when corresponding url is called as mapped below. 
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
    
    
    
    