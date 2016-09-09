<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
		<div class="clear"></div>
		    <div id="popup w3l">
	            <div id="small-dialog" class="mfp-hide aits">
			        <div class="pop_up agileits">
			            <div class="register w3layouts">
				            <form:form action="addUser" method="post">
				                <label>First Name</label>
					            <form:input type="text" name="firstName" placeholder="First Name" path = "firstName" required="required" />
					            <label>Last Name</label>
					            <form:input type="text" name="lastName" placeholder="Last Name" path = "lastName" required="required" />
					            <label>Date Of Birth</label>
					            <form:input type = "datetime" id = "datepicker" name="dateOfBirth" placeholder="Date Of Birth" path = "dateOfBirth" required="" />
					            <label>Gender</label>
					            <form>
                                    <form:input type="radio" name="gender" path = "gender" value="male" > Male<br></form:input>
                                    <form:input type="radio" name="gender" path = "gender" value="female"> Female<br></form:input>
                                    <form:input type="radio" name="gender" path = "gender" value="other"> Other  </form:input>
                                </form> 
					            <label>Email</label>
					            <form:input type="text" name="emailId" placeholder="Email" path = "emailId" required="" />
					            <label>Mobile Number</label>
				                <form:input type="text" name=" mobileNumber" placeholder="Mobile Number" path = "mobileNumber" required="" />
					            <label>Password</label>
					            <form:input type="password" name="password" placeholder="Password" path = "password" required="" />
					            <form:input type = "text" path = "role.roleId" value = "1" readonly />
				                <div class="send-button">
					                <input type="submit" value="REGISTER">
					            </div>
				            </form:form>
				        </div>
			        </div>
			    </div>
		    </div>
		    <button title="Close (Esc)" type="button" class="mfp-close w3layouts"></button>
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
