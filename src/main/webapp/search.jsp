<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search</title>
<jsp:include page="meta.jsp"/>
<style type="text/css">
	.form{
		padding:30px;
		font-size: 30px;
		margin-right:50px;
	}
	.ritefloat{
		float:right;
		margin-right: 250px;
	}
</style>
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="jumbotron col-span-8 col-offset-2">	

<div class="form"><form action="SearchByNameController" method="post">
		Search by Project name <div class="ritefloat"><input type="text" name="name">
		<input type="submit" value="search"></div>
	</form>
</div>
<div class="form">
	<form action="SearchByBackendController" method="post">
		Search by Backend technology <div class="ritefloat"><input type="text" name="backend">
		<input type="submit" value="search"></div>
	</form>
	<p>*eg search "java" for JavaEE or JavaSE or Java(spring)</p>
</div>
<div class="form">	
	<form action="SearchByFrontendController" method="post">
		Search by Front end technology <div class="ritefloat"><input type="text" name="frontend">
		<input type="submit" value="search"></div>
	</form>
</div>	
<div class="form">
	<form action="SearchByUseridController" method="post">
		Search by user-id<div class="ritefloat"><input type="text" name="userid">
		<input type="submit" value="search"></div>
	</form>
</div>
</div>	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>