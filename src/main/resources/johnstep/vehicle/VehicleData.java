package johnstep.vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
//import java.util.GregorianCalendar;

public class VehicleData {
	
	public VehicleData(){
		super();
	}
	
	public VehicleData(int id, int vehicleServiceTypeId, int vehicleId, String description, int mileage
			, double price, String updateDate) throws ParseException{
		this.id = id;
		this.vehicleServiceTypeId = vehicleServiceTypeId;
		this.vehicleId = vehicleId;
		this.description = description;
		this.mileage = mileage;
		this.price = price;
		this.setUpdateDate(updateDate);
				
	}
	
	private int id;
	private int vehicleServiceTypeId;
	private int vehicleId;
	private String description;
	private int mileage;
	private double price;
	private Calendar updateDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVehicleServiceTypeId() {
		return vehicleServiceTypeId;
	}
	public void setVehicleServiceTypeId(int vehicleServiceTypeId) {
		this.vehicleServiceTypeId = vehicleServiceTypeId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	
	public String getUpdateDateString(){
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 	String res = sdf.format(this.updateDate.getTime());
	 
		return res;
	}
	
	public String getUpdateDateRusString(){
	    
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 	String res = sdf.format(this.updateDate.getTime());
	 
		return res;
	}
	
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	public void setUpdateDate(int d, int m, int y){
		Calendar cal = new GregorianCalendar();
		cal.set(y, m-1, d);
		this.updateDate = cal;
	}
	public void setUpdateDate(String s) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cc = new GregorianCalendar();
		cc.setTime(sdf.parse(s));
		
		this.updateDate = cc;
		
	}
	

}
