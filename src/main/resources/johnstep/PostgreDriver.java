package johnstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;


public class PostgreDriver {

	Connection conn;
	
	public PostgreDriver(){
		super();
	}
	
	public void setConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Class.forName ("org.postgresql.Driver").newInstance();
        DriverManager.registerDriver(new Driver());
        conn = DriverManager.getConnection(
             "jdbc:postgresql:postgres", "postgres","Qazqazqaz7");
		
	}
	
	public Connection getConnection(){
		return conn;
	}
	
}
