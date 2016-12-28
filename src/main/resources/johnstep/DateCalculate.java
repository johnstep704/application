package johnstep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateCalculate {
	

	
	public Calendar d1;
	public Calendar d2;
	
	public Date date1;
	public Date date2;
	
	public DateCalculate(){
		super();
	}
	
	
	public Date getDate1() {
		return date1;
	}


	public void setDate1(String s1) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.date1 = format.parse(s1);
	}


	public Date getDate2() {
		return date2;
	}


	public void setDate2(String s1) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.date2 = format.parse(s1);
	}


	


	public Calendar getD1() {
		return d1;
	}


	public void setD1(Calendar d1) {
		this.d1 = d1;
	}


	public Calendar getD2() {
		return d2;
	}


	public void setD2(Calendar d2) {
		this.d2 = d2;
	}
	
	public double daysDiff(){
		double s = d2.getTimeInMillis() -d1.getTimeInMillis();
		s = s/1000/60/60/24;
		
		return s;
	}
	public double daysDiff(Date dd1, Date dd2){
		double s = dd2.getTime()-dd1.getTime();
        s = s/1000/60/60/24;
		
		return s;
	}
	
	
	

}

