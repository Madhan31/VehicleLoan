<<<<<<< HEAD
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

    <c:if test="${Message != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${Message}" />');
            </script>
    </c:if>
>>>>>>> 422b51232604120b55de99016654d82cb35fd5f6
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/stylecf.css" rel="stylesheet" type="text/css" />
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
	 	    $(".pass-icon").css("left","-48px");
	        });
	        $(".password").blur(function() {
		    $(".pass-icon").css("left","0px");
	        });
            });
        </script>
    </head>
    <body>
<<<<<<< HEAD
        <div id="wrapper">
        <div class="user-icon"></div>
        <div class="pass-icon"></div>
        <form name="login-form" class="login-form" action="logIn" method="post">
            <div class="header">
                <h1>Login Form</h1>
                <span>Fill out the form below to login to my super awesome imaginary control panel.</span>
            </div>
            <div class="content">
	        <input name="userId" type="text" class="input username" value="Username" onfocus="this.value=''" />
                <input name="password" type="password" class="input password" value="Password" onfocus="this.value=''" />
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
=======
	<h1>LOAN LOGIN & REGISTER FORMS</h1>
	<div class="container w3layouts agileits">
	    <div class="login w3layouts">
	        <form action="logIn" method="post">
		    <label>User name</label>
		    <input type="text" class="user" name = "userId" placeholder="User Name" required="">
		    <label>Password</label>
		    <input type="password" class="pass" name = "password" placeholder="Password" required="">
		    <input type="submit" value="LOGIN" >
		</form></div>>
	        <div class="clear"></div>
	    </div></br></br>
	    <div class="reg w3l aits">
	        <h3>Not a member?</h3>
	 	<form action="signup">
			<input type = "submit" value = "Register here" />
			</form>
			</div>
	    <script src="js/jquery-2.1.4.min.js"></script>
            <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
            <script>
	        $(document).ready(function() {
	            $('.popup-with-zoom-anim').magnificPopup({
		        type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		    });
	        });
	    </script>
        </body>
>>>>>>> 422b51232604120b55de99016654d82cb35fd5f6
</html>
