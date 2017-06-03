package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;
import dao.UserDao;

/**
 * Servlet implementation class ProfileController
 */
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("profilecontroller Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		System.out.println("\n in profile controller email="+email);
		System.out.println("pass="+password);
				
		User user=UserDao.getUserByEmail(email);
		if(user!=null){
			System.out.println("fetched user country: "+user.country);
			request.setAttribute("user", user);
		}
		else{
			System.out.println("could not fetch user");
		}
		
		List<Project> projectList=ProjectDao.getProjectByUserid(user.id);
		if(projectList!=null){
			System.out.println("fethched project list size"+projectList.size());
			request.setAttribute("projectList", projectList);
			RequestDispatcher rd=request.getRequestDispatcher("user-profile.jsp"); 
			rd.forward(request,response);
		}
		else{
			System.out.println("could not fetch project");
		}
	    out.close();  
	}

}
