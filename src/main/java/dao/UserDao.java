package dao;

import java.sql.*;

import mypack.User;

public class UserDao {
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
        	Class.forName("com.mysql.cj.jdbc.Driver");  
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
	public static boolean validate(String email,String password){  
		boolean status=false;  
		try{  
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement(  
			"select * from user where email=? and password=?");  
			ps.setString(1,email);  
			ps.setString(2,password);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			          
		}catch(Exception e){System.out.println(e);}  
		return status;  
	}
	public static User getUserByEmail(String email){
		User u=new User();
		try{
			System.out.println("dao 1");
			Connection con=UserDao.getConnection();   		 
			PreparedStatement ps=con.prepareStatement("select * from user where email=?");  
			ps.setString(1,email);
			System.out.println("dao 2"+email);

			
			ResultSet rs=ps.executeQuery();
			System.out.println("dao 3");

			if(rs.next()){
				System.out.println("dao 4");
				
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setCollege(rs.getString("college"));
				u.setCountry(rs.getString("country"));
				u.setGithub(rs.getString("github"));
				u.setEmail(rs.getString("email"));
				u.setRank(rs.getInt("rank"));
				u.setPassword(rs.getString("password"));
			}
			System.out.println("in user dao user email fethched="+u.getEmail());
			
			          
		}catch(Exception e){System.out.println(e);}
		return u;
	}
	
}
