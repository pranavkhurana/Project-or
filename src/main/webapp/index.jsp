<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<jsp:include page="meta.jsp"/>
<style>
	.jumbotron{
		font-size: large;
		padding:30px;
		color:orange;
	}
</style>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
	<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-6">
	
		<center>
			<div class="jumbotron"><a href="ViewAllProjects">View All projects</a></div>
			<div class="jumbotron"><a href="search.jsp">Search</a></div>
			<div class="jumbotron"><a href="login.jsp">View Your Projects</a></div>
			<div class="jumbotron"><a href="login.jsp">Submit New project</a></div>
		</center>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-3">
		<div class="jumbotron">
		<center>
			<h3>Trending Projects</h3>
		</center>
		</div>
	</div>
	
	</div>
</div>
<hr>

<jsp:include page="footer.jsp"/>
</body>
</html>