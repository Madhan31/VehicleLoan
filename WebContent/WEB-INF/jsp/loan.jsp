<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<title>Loan Addition</title>
<script>
function emiDetails() {
	  var xhttp;
	  var emi = parseInt(document.getElementById('loanperiod').value); 

	  
	  if (window.XMLHttpRequest) {
	    // code for modern browsers
	    xhttp = new XMLHttpRequest();
	    } else {
	    // code for IE6, IE5
	    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("emidetails").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "emi.html?emi="+emi, true);
	  xhttp.send();
	}
</script>	
<body>  
    <body>
        <form  action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
    <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
    <br></br><p><h1 align = "center">Register Loan Details :</h1>
    <form class = "login">
    <m:out value = "Rs. ${loanamount}"/>
    </form>
    <form:form action = "addloandetail" method = "get" modelAttribute = "Loan" class= "login"><br></br>
    <m:out value = "Rs. ${loanamount}"/>
    <form:select path = "loanPeriod" id = "loanperiod" onchange = "emiDetails();">
    	<option value = "12">1 Year</option>
    	<option value = "24">2 Year</option>
    	<option value = "36">3 Year</option>
   	</form:select>
        <!--<form:input type = "text" name = "emi" path = "emi" placeholder = "Emi" required = "required" /><br></br>
        <form:input type = "text" name = "period" path = "period" placeholder = "Period" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..." /><br></br>  
        <form:input type = "text" name = "documentCharge" path = "documentCharge" placeholder = "Document Charge" required = "required" /><br></br>
        <form:input type = "text" name = "date" path = "date" placeholder = "DD/MM/YYYY" required = "required" /><br></br>
        <form:input type = "text" name = "loanAmount" path = "loanAmount" placeholder = "Loan Amount" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..."/><br></br> -->                
        <input type = "submit" name = "button" value = "Register"/>
    </form:form>
</body>
</html>
