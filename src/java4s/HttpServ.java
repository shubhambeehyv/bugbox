package java4s;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HttpServ extends HttpServlet {
	  protected void doGet( HttpServletRequest request,
              HttpServletResponse response)
throws ServletException, IOException {

//response.getWriter().write("<html><body>GET response</body></html>");
String paramusername = (String)request.getParameter("username");
String parampassword = (String)request.getParameter("password");
boolean matches = false;
try {
	ResultSet rs = ListRecord.selectRecordsFromDbUserTable();
	
	
	while (rs.next()) {
		 
		
		String password = rs.getString("password");
		String username = rs.getString("UserName");
		if(username.trim().equals(paramusername.trim()) && password.equals(parampassword.trim()))
		{
			matches = true;
			break;
		}
		
				
		

		

	}
	
	response.getWriter().write("<html><body>"+(matches?"Logged In!!!":"Invalid Username/Password") + "</body></html>");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}




}

}
