package johnstep.communication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommunicationData {
	
	public CommunicationData(){
		super();
			
	}
	
	public CommunicationData(int id, int propertyId, int comServiceTypeId, String description, String masterName
			, double price, String updateDate ) throws ParseException{
		
		this.id = id;
		this.propertyId = propertyId;
		this.comServiceTypeId = comServiceTypeId;
		this.description = description;
		this.masterName = masterName;
		this.price = price;
		this.setUpdateDate(updateDate); 
	}
	
	private int id;
	private int propertyId;
	private int comServiceTypeId;
	private String description;
	private String masterName;
	private double price;
	private Calendar updateDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public int getComServiceTypeId() {
		return comServiceTypeId;
	}
	public void setComServiceTypeId(int comServiceTypeId) {
		this.comServiceTypeId = comServiceTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
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
	public void setUpdateDate(String s) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cc = new GregorianCalendar();
		cc.setTime(sdf.parse(s));
		
		this.updateDate = cc;
		
	}
	

}
