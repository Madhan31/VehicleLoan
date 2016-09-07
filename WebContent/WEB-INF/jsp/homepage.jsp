<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <title>Loan Addition</title>
      <link rel="stylesheet" href="css/style.css">
    <body>
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
    <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
<<<<<<< HEAD
    <br></br><p><h1 align = "center">Register Eligibility Details :</h1>
    <form:form action = "addeligibilitydetail" method = "get" modelAttribute = "eligibilityDetail" class= "login"><br></br>
        <form:input type = "text" name = "currentcity" path = "currentCity" placeholder = "Current City" required = "required" /><br></br>
                                            <!--<form:select path = "employment">
                                                <form:option value = "select">Select Employment type</form:option>                                            
                                                <form:option value = "Salaried">Salaried</form:option>
                                                <form:option value = "Self Employed">Self Employed Business</form:option>
                                                <form:option value = "Retired">Retired</form:option>
                                            </form:select> -->          
        <form:input type = "text" name = "company" path = "company" placeholder = "company" required = "required" /><br></br>
        <form:input type = "text" name = "salary" path = "salary" placeholder = "salary" required = "required" /><br></br>
        
        <select name = "vehicle" id = "vehicle" onChange="loadvehiclemodels();" >
		   <option value="0"> -- Select Vehicle -- </option>
		<m:forEach items="${vehicleList}" var="vehicle">
		 <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
		</m:forEach>
		 </select>    
		 
<form:select path="vehicleModel.vehicleModelId" id="vehicleModelView" onchange = "loadvehicleprice();" >                    
   <option value="0"> Select Vehicle Model -- </option>	                                         
   </form:select>  <br></br>
   	<div id = "vehicleModelPrice">
   		<textarea readonly style = "width: 100px; height: 15px;">Rs.</textarea>
   		 </div>	      
        <form:input type = "text" name = "downpayment" path = "downPayment" placeholder = "Down Payment" required = "required" /><br></br>                
=======
    <br></br><p><h1 align = "center">Register Loan Details :</h1></p>
    <form:form action = "addloandetail" method = "get" modelAttribute = "Loan" class= "login"><br></br>
        <form:input type = "text" name = "emi" path = "emi" placeholder = "Emi" required = "required" /><br></br>
        <form:input type = "text" name = "period" path = "period" placeholder = "Period" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..." /><br></br>  
        <form:input type = "text" name = "documentCharge" path = "documentCharge" placeholder = "Document Charge" required = "required" /><br></br>
        <form:input type = "text" name = "date" path = "date" placeholder = "DD/MM/YYYY" required = "required" /><br></br>
        <form:input type = "text" name = "loanAmount" path = "loanAmount" placeholder = "Loan Amount" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..."/><br></br>                
>>>>>>> 39ff2bae0147f0d10da95d1e95315a940e4c21b5
        <input type = "submit" name = "button" value = "Register"/>
    </form:form>
</body>
</html>
