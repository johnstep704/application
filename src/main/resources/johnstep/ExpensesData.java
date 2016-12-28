package johnstep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExpensesData {
	
	public ExpensesData(){
		super();
	}
	
	private int id;
	private String description;
	private int monthId;
	private int yearId;
	private int operationType;
	private Calendar updateDate;
	private double amount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMonthId() {
		return monthId;
	}
	public void setMonthId(int monthId) {
		this.monthId = monthId;
	}
	public int getYearId() {
		return yearId;
	}
	public void setYearId(int yearId) {
		this.yearId = yearId;
	}
	public int getOperationType() {
		return operationType;
	}
	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public String getUpdateDateString(){
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
