<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function loadvehiclemodels() {
  var xhttp;
  var vehicle = parseInt(document.getElementById('vehicle').value); 

  
  if (window.XMLHttpRequest) {
    // code for modern browsers
    xhttp = new XMLHttpRequest();
    } else {
    // code for IE6, IE5
    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("vehicleModelView").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "vehicleModelView.html?vehicleId="+vehicle, true);
  xhttp.send();
}

function loadvehicleprice() {
	  var xhttp;
	  var vehiclemodel = parseInt(document.getElementById('vehicleModelView').value); 

	  
	  if (window.XMLHttpRequest) {
	    // code for modern browsers
	    xhttp = new XMLHttpRequest();
	    } else {
	    // code for IE6, IE5
	    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("vehicleModelPrice").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "vehicleModelPrice.html?vehicleModelId="+vehiclemodel, true);
	  xhttp.send();
}
</script>
</head>
<link rel="stylesheet" href="css/style.css">
    <body>
        <br></br>
        <h1 align = "center">Register Eligibility Detail:</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
    <form:form action = "addeligibilitydetail" method = "get" modelAttribute = "eligibilityDetail" class= "login">
        <form:input type = "text" name = "currentcity" path = "currentCity" placeholder = "Current City" required = "required" /><br></br>         
        <form:select path = "company.companyId" >
		   <option value="0"> -- Select Company -- </option>
		<m:forEach items="${companyList}" var="company">
		 <option value="${company.companyId}">${company.companyName}</option>
		</m:forEach>
		 </form:select>         
        <form:input type = "text" name = "salary" path = "salary" placeholder = "salary" required = "required" /><br></br>
        
        <select name = "vehicle" id = "vehicle" onChange="loadvehiclemodels();" >
		   <option value="0"> -- Select Vehicle -- </option>
		<m:forEach items="${vehicleList}" var="vehicle">
		 <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
		</m:forEach>
		 </select>    
		 
<form:select path="vehicleModel.vehicleModelId" id="vehicleModelView" onchange = "loadvehicleprice();" >                    
   <option value="0"> Select Vehicle Model -- </option>	   
   <option></option>                                      
   </form:select>  <br></br>
   	<div id = "vehicleModelPrice">
   		 </div>	      
        <form:input type = "text" name = "downpayment" path = "downPayment" placeholder = "Down Payment" required = "required" /><br></br>
        <form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" />                
        <input type = "submit" name = "button" value = "Proceed"/>
    </form:form>   
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</body>
</html>
     