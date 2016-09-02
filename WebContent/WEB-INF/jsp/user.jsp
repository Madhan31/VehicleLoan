<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
    <head>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
       	<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" 	type="text/css"  media="all">
	<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800" 		type="text/css"  media="all">
    </head>
    <body>
        <h1>USER INFORMATION</h1>
	    <div class="container">
		<div class="contact">
		    <form:form action="addUser" method="post">
		        <label>First Name</label>
			<form:input type="text" name="firstName" placeholder="First Name" path = "firstName"required="required" />
			<label>Last Name</label>
			<form:input type="text" name="lastName" placeholder="Last Name" path = "lastName" required="required" />
			<label>Date Of Birth</label>
			<form:input type = "text" name="dateOfBirth" placeholder="DD/MM/YYYY" path = "dateOfBirth" required="required" />
			<label>Gender</label></br>
			<form>
                            <form:input type="radio" name="gender" path = "gender" value="male" > Male<br></form:input>
                            <form:input type="radio" name="gender" path = "gender" value="female"> Female<br></form:input>
                            <form:input type="radio" name="gender" path = "gender" value="other"> Other  </form:input>
                        </form> 
			<label>Email</label>
			<form:input type="text" name="emailId" placeholder="Email" path = "emailId" required="required" />
			<label>Mobile Number</label>
			<form:input type="text" name=" mobileNumber" placeholder="Mobile Number" path = "mobileNumber" required="required" />
			<label>Password</label>
			<form:input type="password" name="password" placeholder="Password" path = "password" required="required" />
			<div class="send-button">
			    <input type="submit" value="Save">
			</div>
		    </form:form>
		</div>
            </div>
    </body>
</html>
