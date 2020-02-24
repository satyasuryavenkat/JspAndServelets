

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/check")
public class Login extends HttpServlet {
	
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw= response.getWriter();
		//pw.println(Integer.parseInt(s)+Integer.parseInt(s2));
		
		try{
			
		String name=request.getParameter("usname");
		String password = request.getParameter("pswd");
		String nam;
		
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password-1");
		
		PreparedStatement ps= con.prepareStatement("select * from stu");
		ResultSet rs= ps.executeQuery();
		int f=0;
		while(rs.next())
		{
			nam=rs.getString(1);
			if(nam.equals(name) && password.equals("1234"))
			{
				pw.println("Logged in Successfully");
				f=1;
				break;
				
			}
		}
		if(f==0)
		{
			pw.println("Wrong Credentials");
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

	
	

}
