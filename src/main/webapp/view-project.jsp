<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,mypack.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="meta.jsp"></jsp:include>
</head>
<body>
<%
	Project p=(Project)request.getAttribute("project");
%>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="row">
	<div class="col-sm-2"></div>

	<div style="padding:30px" class="col-sm-8">
		<div class="container">
  <h2>Project Details:<%=p.getName() %></h2>
  <p>All details concerning the chosen project:</p>            
  <table class="table">
    <tbody>
      <tr>
        <td>Project Id</td>
        <td><%=p.getProjid()%></td>
      </tr>
      <tr>
        <td>Project Name</td>
        <td><%=p.getName() %></td>
      </tr>
            <tr>
        <td>Backend Technology Used</td>
        <td><%=p.getBackend() %></td>
      </tr>
            <tr>
        <td>Frontend Technology</td>
        <td><%=p.getFrontend() %></td>
      </tr>
            <tr>
        <td>Framework Used</td>
        <td><%=p.getFramework() %></td>
      </tr>
            <tr>
        <td>Short Description</td>
        <td><%=p.getDescription() %></td>
      </tr>
            <tr>
        <td>Github Link</td>
        <td><%=p.getGithublink() %></td>
      </tr>
            <tr>
        <td>Project Rank</td>
        <td><%=p.getRank() %></td>
      </tr>
		            <tr>
        <td>Developer Id</td>
        <td><%=p.getUserid() %></td>
      </tr>
		      
    </tbody>
  </table>
  
</div>
		
	<a href="#" style="font-size: 25px">Download Project Here</a>
	</div>
	<div class="col-sm-2"></div>
	
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>