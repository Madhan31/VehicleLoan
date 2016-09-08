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
	  var loanPeriod = parseInt(document.getElementById('loanperiod').value); 
	  var loanAmount = parseInt(document.getElementById('loanAmount').value); 
	  
	  if (window.XMLHttpRequest) {
	    xhttp = new XMLHttpRequest();
	    } else {
	    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("emidetails").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "emi.html?loanPeriod="+loanPeriod + "&loanAmount="+loanAmount, true);
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
    <br></br><p><h1 align = "center">Decide to Apply :</h1>
    <!--<form class = "login">
    <m:out value = "Rs. ${loanamount}"/>
    </form>-->
    <form action = "addloandetail" method = "get" class= "login"><br></br>
    <div id = "loanAmount">
    <m:out value = "Rs. ${loanamount}"/>
    </div>
    <select path = "loanPeriod" id = "loanperiod" onchange = "emiDetails();">
    	<option value = "12">1 Year</option>
    	<option value = "24">2 Year</option>
    	<option value = "36">3 Year</option>
   	</select>   
   	<div id = "emidetails">
   	<textarea style = "width: 100px; height: 15px; display:none;"></textarea>
   	</div>     
        <input type = "submit" name = "button" value = "Apply Loan"/>
    </form>
</body>
</html>
