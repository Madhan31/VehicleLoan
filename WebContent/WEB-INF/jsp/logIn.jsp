<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
        <title>Login Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         </head>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
    	<c:if test="${sessionScope['role'] == 'admin'}" >
        	<c:redirect url = "adminOperation" />
    	</c:if> 
    	    <c:if test="${sessionScope['role'] == 'user'}" >
        		<c:redirect url = "userOperation" />
    	</c:if>    
<body>
<div>
<div class="jumbotron text-center">
<h2 class="title"> Vehicle Loan</h2>
</div>
<br>
 <div class="row">
		<div class="col-md-12">
                <div id="Carousel" class="carousel slide">
                 
                <ol class="carousel-indicators">
                    <li data-target="#Carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#Carousel" data-slide-to="1"></li>
                    <li data-target="#Carousel" data-slide-to="2"></li>
                </ol>
                 
                <!-- Carousel items -->
                <div class="carousel-inner">
                    
                <div class="item active">
                	<div class="row">
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike1.png" alt="Image" style="max-width:100%;"></a></div>
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike2.png" alt="Image" style="max-width:100%;"></a></div>
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike3.png" alt="Image" style="max-width:100%;"></a></div>
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike4.png" alt="Image" style="max-width:100%;"></a></div>
                	</div><!--.row-->
                </div><!--.item-->
                 
                <div class="item">
                	<div class="row">
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike5.png" alt="Image" style="max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike6.png" alt="Image" style="max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike7.png" alt="Image" style="max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike8.png" alt="Image" style="max-width:100%;"></a></div>
                	</div><!--.row-->
                </div><!--.item-->
                 
                <div class="item">
                	<div class="row">
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike9.png" alt="Image" style="max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike10.png" alt="Image" style="max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike11.png" alt="Image" style="max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="img/bike12.png" alt="Image" style="max-width:100%;"></a></div>
                	</div><!--.row-->
                </div><!--.item-->
                 
                </div><!--.carousel-inner-->
                  <a data-slide="prev" href="#Carousel" class="left carousel-control"><</a>
                  <a data-slide="next" href="#Carousel" class="right carousel-control">></a>
                </div><!--.Carousel-->
                 
		</div>
	</div>
<div class = "panel panel-default col-sm-offset-4 col-sm-4 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Login
      </h2>
   </div>
   
   <div class = "panel-body"><br>
<div class="image-body">
<img src="img/vechile.png" alt="Smiley face" height="75" width="100">
</div>
       
       <form name="login-form" class="login-form" action="logIn" method="post">
       <div class="form-group">
            <label for="user">User Id:</label>
          <input type="text" name="userId" class="form-control" id="user" required>
        </div>
        <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" name="password" class="form-control" id="pwd" required>
      </div>
<div class = "panel-footer footer-align">
<input type="submit" name="submit" value="Login" class="btn btn-info btn-lg pull-center col-sm-4 border input-align" />
</div>          
        </form>
        <form name="login-form" action="signUp" method="post">
        <div><h4 class="text-center">Are you not a member!!!</h4></div>        
               <div><input type="submit" name="submit" value="Register" class="btn btn-info btn-lg pull-left col-sm-4 border input-align" />
               </div><br><br>
        </form>  
</div> 

<style>

.title {
    font-family: "Times New Roman", Times, serif; 
  }
.title-style {
  font-size: 150%;
}
.footer-align {
height : 75px;
}
.border {
border-style: solid double
}
.image-width {
width:250px;
}
.myCarousel-width {
  width:500px;
}
.image-body {
margin-left :50%;
}
.input-align{
margin-left:40%;
}
.r-116 {
right:163px;
}
.carousel {
    margin-bottom: 0;
    padding: 0 40px 30px 40px;
}

/* The controlsy */
.carousel-control {
	left: -12px;
    height: 40px;
	width: 40px;
    background: none repeat scroll 0 0 #222222;
    border: 4px solid #FFFFFF;
    border-radius: 23px 23px 23px 23px;
    margin-top: 90px;
}
.carousel-control.right {
	right: -12px;
}
/* The indicators */
.carousel-indicators {
	right: 50%;
	top: auto;
	bottom: -10px;
	margin-right: -19px;
}
/* The colour of the indicators */
.carousel-indicators li {
	background: #cecece;
}
.carousel-indicators .active {
background: #428bca;
}
</style>
</body>
</html>
