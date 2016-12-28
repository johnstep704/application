package johnstep.vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import johnstep.SqlDriver;

public class Vehicle {
	public Vehicle(){
		super();
	}
	
	SqlDriver driver = new SqlDriver();
	Connection conn;
	
	private ArrayList<VehicleDesc> vdList = new ArrayList<>();
	private ArrayList<VehicleData> vehDataList = new ArrayList<>();
	
	public void setTestVdList(){
		vdList.add(new VehicleDesc(1,"desc","l","vin","sts"));
		vdList.add(new VehicleDesc(2,"desc2","l","vin","sts"));
	}
	
	public ArrayList<VehicleDesc> getVdList() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery("Select * from vehicle");
        
        while(rs.next()){
        	vdList.add(new VehicleDesc(rs.getInt("id"),rs.getString("description"), rs.getString("license_plate")
        	, rs.getString("vin_nr"), rs.getString("sts_nr") ));
           }
           rs.close();
           stat.close();
           conn.close();
		
		return vdList;
	}
	public ArrayList<VehicleData> getDataByVehicleId(int vehicleId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String strQuery = "Select * from vehicle_data where vehicle_id = " + vehicleId + " order by update_date";
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(strQuery);
		
        while(rs.next()){
        	Calendar cal = new GregorianCalendar();
        	cal.setTime(rs.getDate("update_date"));
        	
        	VehicleData vehData = new VehicleData();
        	vehData.setId(rs.getInt("id"));
        	vehData.setVehicleServiceTypeId(rs.getInt("vehicle_service_type_id"));
        	vehData.setDescription(rs.getString("description"));
        	vehData.setMileage(rs.getInt("mileage"));
        	vehData.setPrice(rs.getDouble("price"));
        	vehData.setUpdateDate(cal);
        	
        	vehDataList.add(vehData);
        	//vehData = null;
        }
        rs.close();
        stat.close();
        conn.close();
		
		return vehDataList;
		
	}
	
	public String getVehicleServiceType(int i) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String res = "";
		
		String strQuery = "Select * from vehicle_service_type where id = " + i;
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(strQuery);
        
        while(rs.next()){
        	res = rs.getString("description");
        }
        rs.close();
        stat.close();
        conn.close();
        
        return res;
	}
	
	public void addVehicleData(VehicleData vd) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		
		String strQuery = "insert into vehicle_data (id, vehicle_service_type_id, vehicle_id, description, mileage, price, update_date) "
				+ "values(get_id(2),"+vd.getVehicleServiceTypeId()+ ", "+ vd.getVehicleId() + 
				", '" + vd.getDescription() +"', "+ vd.getMileage() + ", " + vd.getPrice() + ", '" + vd.getUpdateDateString() + "' )";
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
		System.out.println(strQuery);
        stat.execute(strQuery);
        
        stat.close();
        conn.close();
	}

}
