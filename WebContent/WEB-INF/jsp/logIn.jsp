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
    <head>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <link href='//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <body>
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
</html>
