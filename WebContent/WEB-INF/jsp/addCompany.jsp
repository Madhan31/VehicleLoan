<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
    <c:if test="${sessionScope['userId'] == null}" >
        <c:redirect url = "index.jsp" />
    </c:if>
    <c:if test="${sessionScope['role'] != 'admin'}" >
        <c:redirect url = "index.jsp" />
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        </br></br>
        <p><h1 align = "center">Add Company Details:</h1></p>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a> 
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>         
        <c:if test="${insert != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${insert}" />');
            </script>
        </c:if>
        <form:form action = "addCompany" modelAttribute = "insertCompany" class= "login">
            <table>
                <tr>
                    <td>Company Name:</td>
                    <td><form:input type = "text" name = "companyName" path = "companyName" placeholder = "Company name" required = "required" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type = "submit" name = "button" value = "Add"/></td>
                </tr>
            </table>
        </form:form>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${Message}" />');
        </script>
    </c:if>
</html>
