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
        <c:if test="${insert != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${insert}" />');
            </script>
        </c:if>
        <br><h1 align = "center">Enter User ID To Make Payment:</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a> 
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>     
        <form action = "payment" class= "login"><br></br>
                <input type = "text" name = "userId" placeholder = "User Id" required = "required" /><br></br>                
                <input type = "submit" name = "button" value = "Submit"/>
        </form>
    </body>
</html>
