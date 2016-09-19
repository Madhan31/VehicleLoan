<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>    
    <head>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
        <style>
            background-color: lightblue;
            #title {
            	 font-size:40px;
            }
            #title h1{
            	text-align:center;
            	color:black;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/login.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
	        $(".username").focus(function() {
		    $(".user-icon").css("left","-48px");
	        });
	        $(".username").blur(function() {
		    $(".user-icon").css("left","0px");
	        });
	        $(".password").focus(function() {
	 	    $(".pass-icon").css("left","0px");
	        });
	        $(".password").blur(function() {
		    $(".pass-icon").css("left","0px");
	        });
            });
        </script>
    </head>
    <body>    
    	<c:if test="${sessionScope['role'] == 'admin'}" >
        	<c:redirect url = "adminOperation" />
    	</c:if> 
    	    <c:if test="${sessionScope['role'] == 'user'}" >
        		<c:redirect url = "userOperation" />
    	</c:if>  
    	<div class="well" id="title"><h1>Vehicle Loan</h1></div>
        <div id="wrapper">
        <div class="user-icon"></div>
        <div class="pass-icon"></div>
        <form name="login-form" class="login-form" action="logIn" method="post">
            <div class="header">
                <h1>Login</h1>
            </div>
            <div class="content">
	        <input name="userId" type="text" class="input userId" onfocus="this.value=''" placeholder = "user Id"/>
                <input name="password" type="password" class="input password"  onfocus="this.value=''" placeholder = "password" />
            </div>
            <div class="footer">
                <input type="submit" name="submit" value="Login" class="button" />
            </div>
        </form>
        <form name="login-form" class="login-form" action="signUp" method="post">
            <div class="footer">
                <input type="submit" name="submit" value="Register here" class="button" />
            </div>
        </form>
    </div>
    </body>
</html>
