package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;
import dao.UserDao;

/**
 * Servlet implementation class AddProjectController
 */
public class AddProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProjectController() {
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
		//int projid=Integer.parseInt(request.getParameter("projid"));
		String name=request.getParameter("name");
		String backend=request.getParameter("backend");
		String frontend=request.getParameter("frontend");
		String framework=request.getParameter("framework");
		String description=request.getParameter("description");
		String githublink=request.getParameter("githublink");
		String filename=request.getParameter("filename");
		int userid=Integer.parseInt(request.getParameter("userid"));
		
		if(name.isEmpty()||backend.isEmpty()||frontend.isEmpty()||framework.isEmpty()||description.isEmpty()||githublink.isEmpty()||filename.isEmpty()){
			request.getRequestDispatcher("error-page.jsp?error=1").forward(request,response);
		}
		else if(ProjectDao.addProject(name,backend,frontend,framework,description,githublink,filename,userid)>0){
			request.getRequestDispatcher("ProfileController").forward(request, response);			
		}
		else{
			PrintWriter out=response.getWriter();
			out.print("some error occurred in adding project");
		}
	}
}
