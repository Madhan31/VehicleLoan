<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>   
    <title>Add New User</title>
    <body>
        <br></br>
        <h1 align = "center">Register User Details</h1>
        <br></br>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>        
        <form:form action="addUser" modelAttribute = "user" method="post">
            <table>
                <tr>
                <td>First Name</td>
                <td><form:input type = "text" name = "firstName" path = "firstName" placeholder = "First Name" required = "required" /></td>	        
                </tr>
                <tr>
                <td>Last Name</td>
                <td><form:input type="text" name="lastName" placeholder="Last Name" path="lastName" required="required" /></td>
                </tr>
                <tr>
                <td>Date Of Birth</td>
                <td><form:input type = "text" name="dateOfBirth" placeholder="DD/MM/YYYY" path="dateOfBirth" required="required" /></td>
                </tr>
                <tr>
                <td>Gender</td>
                <td><form:select path = "gender">
       		        <option value = "null">--select gender--</option>        
       		        <option value = "male">Male</option>
       		        <option value = "female">Female</option>
       		        <option value = "others">Others</option>       		
         	    </form:select></td>
         	    </tr>
         	    <tr>
         	    <td>Email ID</td>     		
                <td><form:input type="text" name="emailId" placeholder="Email" path="emailId" required="required" /></td>
                </tr>
                <tr>
                <td>Mobile Number</td>
                <td><form:input type="text" name=" mobileNumber" placeholder="Mobile Number" path="mobileNumber" required="required" /></td>
                </tr>
                <tr>
                <td>Password</td>
                <td><form:input type="password" name="password" placeholder="Password" path="password" required="required" /></td>
                </tr>
                <form:input type = "hidden" path = "role.roleId" value = "1" />
                <tr>
                <td></td>
                <td><input type = "submit" name = "button" value = "Register"/></td>
                </tr>
                </table>
            </form:form>
        </body>
       <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>