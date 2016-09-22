<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	      document.getElementById("emiDetails").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "emi.html?loanPeriod="+loanPeriod + "&loanAmount="+loanAmount, true);
	  xhttp.send();
	}
</script>	

<script type="text/javascript">
function getDate()
{
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; 
    var yyyy = today.getFullYear();
    if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
    today = dd+"/"+mm+"/"+yyyy;

    document.getElementById("todayDate").value = today;
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
<body onload = "getDate();">

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
        <li><a href="logout"><span class="glyphicon glyphicon-log-in" style = "color:red;"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>      
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Decide to Apply Loan</small></h1>
            </div>                                 
<div class = "panel panel-default col-sm-offset-4 col-sm-4 col">    
    <div class = "panel-body"><br>     
    <form:form action = "addloandetail" modelAttribute = "loan" method = "get" class="login-form">
   	<div class="form-group">
    <table>
        <tr>
            <td>Loan Amount:</td>
            <td><input type = "text" value = "Rs. ${loanamount}" readonly class="form-control"/></td>
         </tr>
         <tr>
            <td><form:input type="hidden" path = "loanAmount" id = "loanAmount" value = "${loanamount}" /></td>
        </tr>
        <tr>
        <td>Loan Period</td>
            <td><form:select path = "loanPeriod" id = "loanperiod" onchange = "emiDetails();" required="required"  class="form-control">
            		<option value=""> Select tenure -- </option>
    	            <option value = "12">1 Year</option>
    	            <option value = "24">2 Year</option>
    	            <option value = "36">3 Year</option>
   	        </form:select></td>   
   	        </tr>
   	        <tr>
   	<td><form:input type="hidden" path = "date" name="startdate" id="todayDate"/></td>
   	</tr>
	<tr>
	<td><div id = "emiDetails"></div></td>
	</tr>
	<tr>	
   	<td><form:input type = "hidden" path = "eligibilityDetail.id" value = "${eligibilityDetailId}" /></td>
   	</tr>
   	<tr>  
   	<td><form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" /></td>
   	</tr>
    </table>
    </div>  
    <input type = "submit" name = "button" value = "Apply Loan" class="btn btn-info btn-lg pull-right col-sm-4 border input-align"/>
    </form:form>
    </div>
    </div>
<c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>    
</body>
</html>
