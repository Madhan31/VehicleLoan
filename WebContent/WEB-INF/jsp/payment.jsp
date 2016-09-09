<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <title>Payment Addition</title>
        <link rel="stylesheet" href="css/style.css">
        <c:if test = "${loans != null}">
            <table>
                <tr>
                    <th>Loan ID</th>
                    <th>EMI</th>
                    <th>Period</th>
                    <th>Date</th>
                    <th>Loan Amount</th>
                </tr>
                <c:forEach items="${loans}" var="loans">
                    <tr>
                        <td><c:out value="${loans.loanId}" /></td>
                        <td><c:out value="${loans.emi}" /></td>
                        <td><c:out value="${loans.period}" /></td>
                        <td><c:out value="${loans.date}" /></td>
                        <td><c:out value="${loans.loanAmount}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
        <c:if test="${insert != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${insert}" />');
            </script>
        </c:if>
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
        <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
        <br></br><p><h1 align = "center">Payment Details :</h1></p>
        <form:form action = "addVehicle" modelAttribute = "insertVehicle" class= "login"><br></br>
            <fieldset>
                <legand>Insert Vehicle</legand>
                <form:input type = "text" name = "loanId" path = "LoanId" placeholder = "Loan ID" required = "required" /><br></br>
                <form:input type = "text" name = "paymentAmount" path = "paymentAmount" placeholder = "Payment Amount" required = "required" /><br></br>
                <input type = "submit" name = "button" value = "Payment"/>
            </fieldset>
        </form:form>
        <a href = "adminOperation">Back to main page</a>
    </body>
</html>
