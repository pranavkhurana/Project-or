package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mypack.Project;
import mypack.User;

public class ProjectDao {
	public static Connection getConnection(){  
        Connection con=null;
        try{  
        	Class.forName("com.mysql.cj.jdbc.Driver");  
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
	public static int addProject(String name,String backend,String frontend,String framework,String description,String githublink,String filename,int userid){
		int status=0;
		try{
			Connection con=ProjectDao.getConnection();
			
			System.out.println("dao 1");
			PreparedStatement ps=con.prepareStatement("insert into project(name,backend,frontend,framework,description,githublink,filename,userid,rank) values (?,?,?,?,?,?,?,?,?) ");
		    
			System.out.println("dao 2");
			ps.setString(1,name);  
	        ps.setString(2,backend);  
	        ps.setString(3,frontend);  
	        ps.setString(4,framework);  
	        ps.setString(5,description);  
	        ps.setString(6,githublink);  
	        ps.setString(7,filename); 
	        ps.setInt(8,userid);
	        ps.setInt(9, 1);
	        
	        System.out.println("dao 3");
	        status=ps.executeUpdate();  
	        System.out.println("dao 4");
	        con.close();  
	     
		}catch(Exception ex){ex.printStackTrace();}  
	          
	     return status;  
	}
	public static List<Project> getProjectByUserid(int userid){
		List<Project> projectList=new ArrayList<Project>();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project where userid=?");  
			ps.setInt(1,userid);
			System.out.println("dao 2"+userid);
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				Project p=new Project();
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
				projectList.add(p);
			}
			System.out.println("in project dao project list size fethched="+projectList.size());
			          
		}catch(Exception e){System.out.println(e);}
		return projectList;
	}
	public static Project getProjectByProjid(int projid){
		Project p=new Project();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project where projid=?");  
			ps.setInt(1,projid);
			System.out.println("dao 2"+projid);
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
			}
			System.out.println("in project dao project fethched="+p.getName());
			          
		}catch(Exception e){System.out.println(e);}
		return p;
	}

	public static List<Project> getAllProjects(){
		List<Project> projectList=new ArrayList<Project>();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project");  
			System.out.println("dao 2");
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				Project p=new Project();
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
				projectList.add(p);
			}
			System.out.println("in project dao project list size fethched="+projectList.size());
			          
		}catch(Exception e){System.out.println(e);}
		return projectList;
	}
	public static List<Project> getProjectsByName(String name){
		List<Project> projectList=new ArrayList<Project>();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project where name like '%"+name+"%'");  
			//ps.setString(1,name);
			
			System.out.println("dao 2"+name);
			System.out.println(ps.toString());
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				Project p=new Project();
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
				projectList.add(p);
			}
			System.out.println("in project dao project list size fethched="+projectList.size());
			          
		}catch(Exception e){System.out.println(e);}
		return projectList;
	}
	public static List<Project> getProjectsByBackend(String backend){
		List<Project> projectList=new ArrayList<Project>();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project where backend like '%"+backend+"%'");  
			//ps.setString(1,name);
			
			System.out.println("dao 2"+backend);
			System.out.println(ps.toString());
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				Project p=new Project();
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
				projectList.add(p);
			}
			System.out.println("in project dao project list size fethched="+projectList.size());
			          
		}catch(Exception e){System.out.println(e);}
		return projectList;
	}
	public static List<Project> getProjectsByFrontend(String frontend){
		List<Project> projectList=new ArrayList<Project>();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project where frontend like '%"+frontend+"%'");  
			//ps.setString(1,name);
			
			//System.out.println("dao 2"+backend);
			System.out.println(ps.toString());
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				Project p=new Project();
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
				projectList.add(p);
			}
			System.out.println("in project dao project list size fethched="+projectList.size());
			          
		}catch(Exception e){System.out.println(e);}
		return projectList;
	}
	public static List<Project> getProjectsByFramework(String framework){
		List<Project> projectList=new ArrayList<Project>();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from project where framework like '%"+framework+"%'");  
			//ps.setString(1,name);
			
			//System.out.println("dao 2"+backend);
			System.out.println(ps.toString());
			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			while(rs.next()){
				
				Project p=new Project();
				System.out.println("dao 4");
				
				p.setProjid(rs.getInt("projid"));
				p.setName(rs.getString("name"));
				p.setBackend(rs.getString("backend"));
				p.setFrontend(rs.getString("frontend"));
				p.setDescription(rs.getString("description"));
				p.setFilename(rs.getString("filename"));
				p.setFramework(rs.getString("framework"));
				p.setGithublink(rs.getString("githublink"));
				p.setRank(rs.getInt("rank"));
				p.setUserid(rs.getInt("userid"));
				
				projectList.add(p);
			}
			System.out.println("in project dao project list size fethched="+projectList.size());
			          
		}catch(Exception e){System.out.println(e);}
		return projectList;
	}


}
