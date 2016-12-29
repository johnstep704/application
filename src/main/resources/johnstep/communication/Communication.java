package johnstep.communication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import johnstep.SqlDriver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Communication {
	
	public Communication(){
		super();
	}
	
	SqlDriver driver = new SqlDriver();
	Connection conn;
	Statement stat; 
	
	public void initConnect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		stat = (Statement) conn.createStatement();
	}
	
	public void closeConnect(){
        try {
			conn.close();
			stat.close();
		} catch (SQLException e) {
			throw new RuntimeException("SQL Exception in call method closeConnect()!");
		}
        
	}
	
	public void addSql(String query){
	     try {
	    	 stat.execute(query);
		} catch (SQLException e) {
			throw new RuntimeException("Check Database connection!");
		}
	}
	
	public ResultSet getSQLQuery(String query){
		ResultSet resultSet;
		try {
			resultSet = stat.executeQuery(query);
		} catch (SQLException e) {
			throw new RuntimeException("Check Database connection!");
		}
		return resultSet;
	}
	
	
	public ArrayList<Property> getPropertyList() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ArrayList<Property> propertyList = new ArrayList<>();
		
		String vQuery = "select * from Property";
        
		ResultSet rs=this.getSQLQuery(vQuery);
        
        while(rs.next()){
        	
        	Property prop = new Property();
        	prop.setId(rs.getInt("id"));
        	prop.setDescription(rs.getString("description"));
        	
        	propertyList.add(prop);
        	
        }
        
        rs.close();
		
		return propertyList;
	}
	
	public ArrayList<ComServiceType> getComServiceList() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ArrayList<ComServiceType> comServiceTypeList = new ArrayList<>();
		
		String vQuery = "select * from com_service_type";
		
		ResultSet rs=this.getSQLQuery(vQuery);
		
        
        while(rs.next()){
        	
        	ComServiceType serviceType = new ComServiceType();
        	serviceType.setId(rs.getInt("id"));
        	serviceType.setDescription(rs.getString("description"));
        	
        	comServiceTypeList.add(serviceType);
        	
        }
        
        rs.close();
 		return comServiceTypeList;
		
	}
	
	public ArrayList<CommunicationData> getCommunicationList(int propertyId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ArrayList<CommunicationData> list = new ArrayList<>();
		
		String vQuery = "select * from communication_data where property_id = " + propertyId + " order by update_date";
		ResultSet rs=this.getSQLQuery(vQuery);
        
        while(rs.next()){
        	
        	Calendar cal = new GregorianCalendar();
        	cal.setTime(rs.getDate("update_date"));
        	
        	CommunicationData cd = new CommunicationData();
        	cd.setId(rs.getInt("id"));
        	cd.setPropertyId(rs.getInt("property_id"));
        	cd.setComServiceTypeId(rs.getInt("com_service_type_id"));
        	cd.setDescription(rs.getString("description"));
        	cd.setMasterName(rs.getString("master_name"));
        	cd.setPrice(rs.getDouble("price"));
        	cd.setUpdateDate(cal);
        	list.add(cd);
        	
        }
		
		return list;
	}
	
	public void addCommData(CommunicationData cd) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String vQuery = "insert into communication_data (id, property_id, com_service_type_id, description, master_name, price, update_date) "
		+ "values( get_id(4), " + cd.getPropertyId() + ", " + cd.getComServiceTypeId() + ", '" + cd.getDescription() +"', '" 
		+ cd.getMasterName() + "', " + cd.getPrice() + ", '" + cd.getUpdateDateString() +"')" ;

		this.addSql(vQuery);

	}
	
	public String getServiceType(int i) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String res = "";
		
		String strQuery = "Select * from com_service_type where id = " + i;
		ResultSet rs=this.getSQLQuery(strQuery);
        
        while(rs.next()){
        	res = rs.getString("description");
        }
        rs.close();
        return res;
	}
	

}
