package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;

/**
 * Servlet implementation class SearchByUseridController
 */
public class SearchByUseridController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByUseridController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int name=Integer.parseInt(request.getParameter("userid"));
		
		List<Project> projectList=ProjectDao.getProjectByUserid(name);
		if(projectList!=null){
			System.out.println("fethched project list size"+projectList.size());
			request.setAttribute("projectList", projectList);
			RequestDispatcher rd=request.getRequestDispatcher("all-projects.jsp"); 
			rd.forward(request,response);
		}
		else{
			System.out.println("could not fetch projects");
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp"); 
			rd.forward(request,response);
		}
	    out.close();  
	}

}
