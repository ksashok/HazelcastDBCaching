package hazelcast_cache;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ashok.dbconn.DBConnection;

public class DBConnectionTest {
	
	@Test
	public void testConnection() {
		
		DBConnection conn = new DBConnection();
		Connection conn1 = conn.getConnection();
		
		try {
			Statement stmt = conn1.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from userCache");
			
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
			}
		finally{
			try {
				conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
