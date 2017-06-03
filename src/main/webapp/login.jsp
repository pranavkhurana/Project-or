<%
/* response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server
 */
 
/* if(session.getAttribute("name")==null){
	request.getRequestDispatcher("ProfileController").forward(request,response);
} */
//out.print("Hi "+session.getAttribute("email")+"!");
%> 

<!DOCTYPE html>
<html lang="en">
<head>
  <title>title</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="http://getbootstrap.com.vn/examples/equal-height-columns/equal-height-columns.css" />
  <link rel="stylesheet" type="text/css" href="resources/css/custom-home.css">
  <link rel="stylesheet" type="text/css" href="">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="navbar.jsp"/>

<!-- page body container-->
<div class="container">
  <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
    	<div class="jumbotron">
		  <h2>Login</h2>
		  <form action="Login" method="post">
		    <div class="form-group">
		      <label for="email">Email:</label>
		      <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
		    </div>
		    <div class="form-group">
		      <label for="pwd">Password:</label>
		      <input type="password" name="password" class="form-control" id="pwd" placeholder="Enter password">
		    </div>
		    <div class="checkbox">
		      <label><input type="checkbox"> Remember me</label>
		    </div>
		    <button type="submit" class="btn btn-default">Submit</button>
		  </form>
		</div>   
    </div>
    <div class="col-sm-2"></div>
  </div> <!-- end-row -->
</div><!-- end container -->
<hr>
<jsp:include page="footer.jsp"/>
</body>
</html>