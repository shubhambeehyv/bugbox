package java4s;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListRecord {

	public static ResultSet selectRecordsFromDbUserTable() throws SQLException {
		 
		Connection dbConnection = null;
		Statement statement = null;
 
		String selectTableSQL = "SELECT password, UserName from Userdatabase.User";
		ResultSet rs = null;
 
		try {
			dbConnection = JDBCConnection.getConnection();
			statement = dbConnection.createStatement();
 
			System.out.println(selectTableSQL);
 
			// execute select SQL stetement
			 rs = statement.executeQuery(selectTableSQL);
 
			/*while (rs.next()) {
 
				String userid = rs.getString("USER_ID");
				String username = rs.getString("USERNAME");
 
				System.out.println("userid : " + userid);
				System.out.println("username : " + username);
 
			}*/
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			
 
		}
		return rs;
	}
	
}
