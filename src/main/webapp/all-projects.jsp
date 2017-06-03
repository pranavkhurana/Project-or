<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,mypack.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<jsp:include page="meta.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<center><h2>Displaying All projects</h2></center>
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
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>