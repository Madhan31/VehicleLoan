<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <c:if test="${sessionScope['userId'] == null}" >
        <c:redirect url = "logIn.jsp" />
    </c:if>
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
		</form>
	        <div class="clear"></div>
	    </div></br></br>
	    <div class="reg w3l aits">
	        <h3>Not a member?</h3>
	 	<a class="popup-with-zoom-anim hvr-underline-from-left" href="#small-dialog">Register Here</a>
		<div class="clear"></div>
		    <div id="popup w3l">
	                <div id="small-dialog" class="mfp-hide aits">
			    <div class="pop_up agileits">
			        <div class="register w3layouts">
				    <form action="addUser" method="post">
				        <label>First Name</label>
					<form:input type="text" name="firstName" placeholder="First Name" required="" />
					<label>Last Name</label>
					<form:input type="text" name="lastName" placeholder="Last Name" required="" />
					<label>Date Of Birth</label>
					<form:input type = "datetime" id = "datepicker" name="dateOfBirth" placeholder="Date Of Birth" required="" />
					<label>Gender</label></br>
					<form>
                                            <form:input type="radio" name="gender" value="male" > Male<br></form:input>
                                            <form:input type="radio" name="gender" value="female"> Female<br></form:input>
                                            <form:input type="radio" name="gender" value="other"> Other  </form:input>
                                        </form> 
					<label>Email</label>
					<form:input type="text" name="emailId" placeholder="Email" required="" />
					<label>Mobile Number</label>
				        <form:input type="text" name=" mobileNumber" placeholder="Mobile Number" required="" />
					<label>Password</label>
					<form:input type="password" name="password" placeholder="Password" required="" />
				        <div class="send-button">
					    <input type="submit" value="REGISTER">
					</div>
				    </form>
				</div>
			    </div>
			</div>
		    </div>
		    <button title="Close (Esc)" type="button" class="mfp-close w3layouts">×</button>
		</div>
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
