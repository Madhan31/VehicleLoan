<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <link rel="stylesheet" href="css/style.css">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Eligibility Detail</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="userOperation">Home</a></li>
        <li class = "active"><a href="#">Apply For Loan</a></li>
        <li><a href="retrieveUserLoanDetail">View Loan Detail</a></li>
        <li><a onclick="javascript:history.back()">Go Back</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>      
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Register Eligibility Detail</small></h1>
            </div> 
    <c:if test="${null != loanDetail.balanceAmount}">
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "There is a pending loan in your account!!!" />');
            window.location.href="userOperation";
        </script>    
    </c:if>	
<div class = "panel panel-default col-sm-offset-4 col-sm-4 col">    
    <div class = "panel-body"><br> 
    <form:form action = "addeligibilitydetail" method = "get" modelAttribute = "eligibilityDetail" class="login-form">
    	<div class="form-group">
    	<table>
    	<tr>
        <td><form:input type = "text" name = "currentcity" path = "currentCity" placeholder = "Current City" required = "required" class="form-control"/><br></br></td>
        </tr>
        <tr>         
        <td><form:select path = "company.companyId" required="required" class="form-control" style = "width: 300px; height: 40px;">        
		   <option value=""> -- Select Company -- </option>
		<m:forEach items="${companyList}" var="company">
		 <option value="${company.companyId}">${company.companyName}</option>
		</m:forEach>
		 </form:select></td>
		 </tr>
		 <tr>         
        <td><form:input type = "text" name = "salary" path = "salary" placeholder = "Salary per month" required = "required" class="form-control"/><br></br></td>
        </tr>
        <tr>
        <td><select name = "vehicle" id = "vehicle" onChange="loadvehiclemodels();" required="required" class="form-control" style = "width: 300px; height: 40px;">
		   <option value=""> -- Select Vehicle -- </option>
		<m:forEach items="${vehicleList}" var="vehicle">
		 <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
		</m:forEach>
		 </select></td>
		 </tr>    
		 <tr>		 
<td><form:select path="vehicleModel.vehicleModelId" id="vehicleModelView" onchange = "loadvehicleprice();" required="required" class="form-control" style = "width: 300px; height: 40px;">                    
   <option value=""> Select Vehicle Model -- </option>	   
   <option></option>                                      
   </form:select></td>
   </tr>
   <tr>
   	<td><div id = "vehicleModelPrice"></div></td>
   		 </tr>
   		 <tr>	      
        <td><form:input type = "text" name = "downpayment" path = "downPayment" placeholder = "Down Payment" required = "required" class="form-control"/><br></br></td>
        </tr>
        <tr>
        <td><form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" /></td>
        </tr>
        </table>  
        </div>              
        <input type = "submit" name = "button" value = "Proceed" class="btn btn-info btn-lg pull-left col-sm-4 border input-align"/>
    </form:form>   
    </div>
</div>    
    <c:if test="${null != message}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href="homePage";
        </script>
    </c:if>
</body>
</html>
     