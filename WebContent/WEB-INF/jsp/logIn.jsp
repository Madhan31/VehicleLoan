<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<html lang="en">
<head>
  <title>Welcome to I2I vehicle loan</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="about">About</a></li>
        <li><a href="contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="signUp"><span class="glyphicon glyphicon-log-in" style = "color:blue;"></span> New User</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
   
<div class="col-md-8 text-left"> 
<div id="mycarousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="item active">
        <img src="img/twowheeler.png" alt="" class="img-responsive">
           <div class="carousel-caption">
                                        
           </div>
        </div>
    </div>
</div>    
      <h1>Welcome</h1>
      <p>Loan sharks have been prevalent among our society since the beginning of early civilization. Illegal money lenders will often stop at nothing to collect the extortionate interest rates due to them. 
      Such is the case below. 
      The following mafia loan sharks were infamously world renowned for committing the most violent and heinous acts when owed money.</p>
      <hr>
    </div>
    <div class="row row-bottom-margin">
    <div class="col-sm-4 sidenav">
<div class = "panel panel-default col-sm-offset-0 col-sm-11 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Login
      </h2>
   </div>    
   <div class = "panel-body"><br>    
       <form name="login-form" class="login-form" method="post" action="logIn" >
       <div class="form-group">
          <input type="text" name="userId" class="form-control" id="user" placeholder = "User Id" required>
        </div>
        <div class="form-group">
      <input type="password" name="password" class="form-control" id="pwd" placeholder = "Password" required>
      </div>
    <div class="checkbox" style = "margin-left: -198px">
      <label style = "margin-bottom: 17px"><input type="checkbox"> Remember me</label>
    </div>
<input type="submit" name="submit" value="Login" class="btn btn-info btn-lg pull-right col-sm-4 border input-align" />

</form> 
</div>
</div>
      </div>
    </div>
  </div>
</div>
</body>
<c:if test="${null != message}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href="homePage";
        </script>
    </c:if>
</html>
