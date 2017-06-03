<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,mypack.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User-profile</title>
<jsp:include page="meta.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-6">
		<div class="jumbtron">
		<h1>User Details</h1>
		<div style="font-size:25px">
		<%
		
			User u=(User)request.getAttribute("user");
			//out.print(u.getEmail()+" "+u.getName()+" "+u.getId()+"<br>");
			
			out.print("Username	:"+u.getName()+"<br>");
			out.print("Id		:"+u.getId()+"<br>");			
			out.print("Email	:"+u.getEmail()+"<br>");
			out.print("Country	:"+u.getCountry()+"<br>");
			out.print("College	:"+u.getCollege()+"<br>");
			out.print("Rank		:"+u.getRank()+"<br>");
			out.print("Github profile:"+u.getGithub()+"<br>");
		%>
		</div>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<hr>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-6">
		<div class="jumbtron">
		<h1>Projects of <%=u.getName() %></h1>
		
<%
	
	List<Project> projectList=(ArrayList<Project>)request.getAttribute("projectList");
	for(int i=0;i<projectList.size();i++){
		Project p=projectList.get(i);
%>
<div style="width:300px;height:290px;background-image: url('resources/images/file.png')" class="project">
<center style="padding-top: 110px;font-size: 41px;">
	<%
		out.print("<a style='color:black' href='ViewProject?projid="+p.getProjid()+"'>");
		out.print(p.getName());
		out.print("</a>");
	%>
</center>
</div>
<%		
	}
%>
		
<%/* 
				List<Project> projectList=(ArrayList<Project>)request.getAttribute("projectList");
				for(int i=0;i<projectList.size();i++){
					Project p=projectList.get(i);
					out.print(p.getName()+" "+p.getGithublink()+"<br>");
 				}
				*/
%>
		</div>
	</div>
	<div style="font-size: 25px" class="col-sm-4">
		<h1>Submit new Project here</h1>
		<form action="AddProjectController" method="post">
		<input type="hidden" name="userid" value="<%=u.getId()%>">
		<input type="hidden" name="email" value="<%=u.getEmail()%>">
		<input type="hidden" name="password" value="<%=u.getPassword()%>">
		<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Backend:</td>
			<td><input type="text" name="backend"></td></tr>
		<tr>
			<td>Frontend:</td>
			<td><input type="text" name="frontend"></td></tr>
		<tr>
			<td>Desc:</td>
			<td><input type="text" name="description"></td>
		</tr>
		<tr>
			<td>Framework:</td>
			<td><input type="text" name="framework"></td>
		</tr>
		<!-- <tr><td>Userid:</td><td><input type="text" name="userid"></td></tr> -->
		<tr>
			<td>Githublink:</td>
			<td><input type="text" name="githublink"></td>
		</tr>
		<tr>
			<td>filename:</td>
			<td><input type="text" name="filename"></td>
		</tr>
		<tr>
			<td>Upload Project(as zip):</td>
			<td><input type="file"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add project"></td>
		</tr>
	</table>
</form>
		
	</div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>