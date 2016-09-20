<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Payment Addition</title>
<script type="text/javascript">
function getDate()
{
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
    today = dd+"/"+mm+"/"+yyyy;

    document.getElementById("todayDate").value = today;
}
</script>
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <head>        
    <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                background-color: #c8897b;
            }            
            tr:nth-child(even) {
                background-color: #dddddd;
            }
    </style>
    </head>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBackAv">
                <img src="img/back.png" alt="logout" style="width:47px;height:42px;border:0;" onclick="javascript:history.back()">
            </div>
    <title>Add Payment</title>
    <body onload = "getDate();">
    <div class = "container">
        <c:if test = "${loans != null}">
            <table class = "table">
                <thead>
                <tr class = "success">
                    <th>Loan ID</th>
                    <th>EMI</th>
                    <th>Period</th>
                    <th>Date</th>
                    <th>Loan Amount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${loans}" var="loans">
                    <tr class = "info">
                        <td><c:out value="${loans.loanId}" /></td>
                        <td><c:out value="${loans.emi}" /></td>
                        <td><c:out value="${loans.loanPeriod}" /></td>
                        <td><c:out value="${loans.date}" /></td>
                        <td><c:out value="${loans.loanAmount}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>   
        </div>
        <br></br><h1 align = "center">Payment Details :</h1>
        <form:form action = "paymentConfirm" modelAttribute = "payment" class= "login"><br></br>
            <fieldset>
                <form:input type = "text" name = "loan" path = "loan.loanId" placeholder = "Loan ID" required = "required" /><br></br>
                <form:input type = "text" name = "paymentAmount" path = "paymentAmount" placeholder = "Payment Amount" required = "required" /><br></br>
                <form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" /> <br></br>
                <form:input type = "hidden" path = "date" name = "startdate" id = "todayDate"/>
                <input type = "submit" name = "button" value = "Payment"/>
            </fieldset>
        </form:form>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>
