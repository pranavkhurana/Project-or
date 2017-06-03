<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="meta.jsp"></jsp:include>
<title>Error</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div style="padding:40px;margin:20px" class="jumbotron">
<center>
<h2>Error page</h2>
<hr>
<h3 style="color:red">
<%
if(request.getParameter("error").equals("1"))
	out.print("Please fill in all fields.");
if(request.getParameter("error").equals("2")){
	
}
if(request.getParameter("error").equals(null)){
	out.print("Some error occurred");
}

%>
</h3>
</center>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>