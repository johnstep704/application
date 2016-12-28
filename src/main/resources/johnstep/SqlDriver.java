package johnstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class SqlDriver {
	
	Connection conn;
	
	public SqlDriver(){
		super();
	}
	
	public void setConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Class.forName ("com.mysql.jdbc.Driver").newInstance();
        DriverManager.registerDriver(new Driver());
        conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/test", "johnstep","johnedition");
		
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	
	
	
	

}
