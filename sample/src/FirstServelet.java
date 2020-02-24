

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServelet
 */
@WebServlet("/surya")
public class FirstServelet extends HttpServlet {
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw= response.getWriter();
		//pw.println(Integer.parseInt(s)+Integer.parseInt(s2));
		
		try{
			
		String name=request.getParameter("uname");
		String mail = request.getParameter("mail");
		String age=request.getParameter("age");
		
		String gender = request.getParameter("gender");
		
		String clgname=request.getParameter("clgname");
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password-1");
		
		PreparedStatement ps= con.prepareStatement("insert into stu values(?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, mail);
		ps.setInt(3, Integer.parseInt(age));
		ps.setString(4, gender);
		ps.setString(5, clgname);
		int k= ps.executeUpdate();
		
		if(k==1)
		{
			pw.println("Data inserted Successfully");
		}
		else
		{
			pw.println("Something Went Wrong");
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	
	

}
