package johnstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import johnstep.vehicle.*;
import johnstep.communication.*;

import com.mysql.jdbc.Driver;


public class Test {
	
	public static void main(String [] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ParseException{
		String sAmount = "700000";
		String sMonths = "36";
		String sPercent = "19.9";

		Double cAmount = Double.parseDouble(sAmount) ;
		int cMonths = Integer.parseInt(sMonths);
		Double cPercent = Double.parseDouble(sPercent);
		
		Expenses exp = new Expenses();
		
		//Double d1 = (double) 147012;
		//exp.setOpeningBalance(d1);
		System.out.println("OpeningBalance = " + exp.getOpeningBalance());
		System.out.println("Rest amount = " + exp.getRestAmount());
		System.out.println("Opening balanseDate = " + exp.getOpeningBalanceDate());
		System.out.println("getFundAmount = " + exp.getFundAmount(1));
		System.out.println("getFundAmountRouble = " + exp.getFundAmountRoubles(1));
		//exp.setCurrency(1, 63.3);
		System.out.println("-----------------------------------");
		
		for(ExpensesData ed : exp.getExpensesData(2016, 12)){
			System.out.println();
			System.out.print(ed.getId() + ", " + ed.getDescription() + ", " + ed.getAmount());
			
		}
		
		
		
	
		

		
	
				
	}

}
