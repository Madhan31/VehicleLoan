<!DOCTYPE html>
<html lang="en">
<head>
  <title>Welcome to I2I vehicle loan</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
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
        <li><a href="signUp"><span class="glyphicon glyphicon-log-in"></span> New User</a></li>
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
       <form name="login-form" class="login-form" action="logIn" method="post">
       <div class="form-group">
          <input type="text" name="userId" class="form-control" id="user" placeholder = "User Id" required>
        </div>
        <div class="form-group">
      <input type="password" name="password" class="form-control" id="pwd" placeholder = "Password" required>
      </div>
<div class = "panel-footer footer-align">
<input type="submit" name="submit" value="Login" class="btn btn-info btn-lg pull-right col-sm-4 border input-align" />
</div>  
</form> 
</div>
</div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
