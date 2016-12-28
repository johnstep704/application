package johnstep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import ifc.*;

public class Expenses {
	
	int id;
	int operType;
	double amount;
	int month;
	int year;
	Calendar insertDate;

	double totalAmount;
	
	
	SqlDriver driver = new SqlDriver();
	
	ExpensesType expType;
	Connection conn;
	
	Collection<ExpensesType> et = new ArrayList<ExpensesType>();
	
	public Expenses(){
		super();

	}
	
	public Collection<ExpensesType> getExpensesTypes(){
		return et;
	}
	
	public ExpensesType getExpensesTypeById(int i) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ExpensesType et = new ExpensesType(); 
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery("Select * from t_operation_type where id  = " + i);
		
        while(rs.next()){
        	et = new ExpensesType();
        	et.setId(rs.getInt("id"));
        	et.setDescription(rs.getString("description"));
        }
        rs.close();
        stat.close();
        conn.close();
        
		return et;
	}
	
	public void addExpTypes(int id, String dsc){
		et.add(new ExpensesType(id,dsc ));
	}
	
	public void setExpTypes() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery("Select * from t_operation_type");
        
        while(rs.next()){
        	this.addExpTypes(rs.getInt("id"), rs.getString("description"));
           }
           rs.close();
           stat.close();
           conn.close();
		
	}
	
	public void setTotalAmount(int m, int y) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String statement = "Select * from v_total where month_id = "+m + " and year_id = "+ y + " and oper_type_id not in (11,12)" ;
		double amt =  0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	amt = amt+rs.getDouble("total");
        }
        totalAmount = amt;
        rs.close();
        stat.close();
        conn.close();
	}
	
	public void setOpeningBalance(double d) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String sqlString = "update t_user_system_params set system_value = "+d +", update_date = sysdate() where userid = 1 and system_param_id = 1";
		
		String updateOpenId = "update t_user_system_params set system_value = (select max(id) from expenses), update_date = sysdate() where userid = 1 and system_param_id = 2";
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
		stat.execute(sqlString);
		stat.execute(updateOpenId);

        stat.close();
        conn.close();
		
	}
	public void setCurrency(int currencyId, double amount) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String sqlString = "update currency set price = "+ amount + " where id = " + currencyId;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
		stat.execute(sqlString);
		
		stat.close();
        conn.close();
	}
	public double getCurrency(int currencyId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		double price=0;
		String sqlString = "select * from currency where id = "+ currencyId;
		
		String statement = "select * from t_user_system_params where userid = 1 and system_param_id = 1";
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(sqlString);
        
        while(rs.next()){
        	price = rs.getDouble("price");
        }
        rs.close();
        stat.close();
        conn.close();
		
		return price;
	}
	
	public double getOpeningBalance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		double amt = 0;
		
		String statement = "select * from t_user_system_params where userid = 1 and system_param_id = 1";
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	amt = amt+rs.getDouble("system_value");
        }
        totalAmount = amt;
        rs.close();
        stat.close();
        conn.close();
        return amt;
	}
	public String getOpeningBalanceDate()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String statement = "select * from t_user_system_params where userid = 1 and system_param_id = 1";

	    Date upDate = null;
		String openDateStr = "";
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	
        	upDate = rs.getDate("update_date");

        }
	    
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		openDateStr = format.format(upDate) ;

        rs.close();
        stat.close();
        conn.close();
		return openDateStr;
	}
	
	public double getTotal(int m, int y) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String statement = "Select * from v_total where month_id = "+m + " and year_id = "+ y + " and oper_type_id not in (11,12) " ;
		double amt =  0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	amt = amt+rs.getDouble("total");
        }
        totalAmount = amt;
        rs.close();
        stat.close();
        conn.close();
        return (double) Math.round(amt * 100) / 100;
	}
	
	public double getTotalPerYear(int y) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String statement = "Select * from v_total where year_id = "+ y + " and oper_type_id not in (11,12) " ;
		double amt = 0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	amt = amt+rs.getDouble("total");
        }
        totalAmount = amt;
        rs.close();
        stat.close();
        conn.close();
        return (double) Math.round(amt * 100) / 100;
	}
	
	public double getAmountByType(int type, int m, int y) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String statement = "Select * from v_total where month_id = "+m + " and year_id = "+ y + " and oper_type_id = "+type ;
		
		double amt = 0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	amt = amt+rs.getDouble("total");
        }
        totalAmount = amt;
        rs.close();
        stat.close();
        conn.close();
		
        return (double) Math.round(amt * 100) / 100;
	}
	
	public double getYearlyAmountByType(int type, int y) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String statement = "Select * from v_total where year_id = "+ y + " and oper_type_id = "+type ;
		
		double amt =  0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(statement);
        
        while(rs.next()){
        	amt = amt+rs.getDouble("total");
        }
        totalAmount = amt;
        rs.close();
        stat.close();
        conn.close();
		
        return (double) Math.round(amt * 100) / 100;
		
	}
	
	public double getRestAmount() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String expensesString = "Select * from expenses where id > (select system_value from t_user_system_params where userid = 1 and system_param_id = 2 )"
				+ "and operation_type_id in (select id from t_operation_type where is_income = 0)" ;
		
		String incomeString = "Select * from expenses where id > (select system_value from t_user_system_params where userid = 1 and system_param_id = 2 )"
				+ "and operation_type_id in (select id from t_operation_type where is_income = 1)" ;
		
		
		double amt = 0;
		
		double expAmt = 0;
		double incomeAmt = 0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(expensesString);
        
        while(rs.next()){
        	expAmt = expAmt+rs.getDouble("amount");
        }
        
        rs = stat.executeQuery(incomeString);
        while(rs.next()){
        	incomeAmt = incomeAmt+rs.getDouble("amount");
        }
        rs.close();
        stat.close();
        conn.close();
        
        amt = this.getOpeningBalance() - expAmt + incomeAmt;
		
		double amtFinal = amt + this.getFundAmountRoubles(1) + this.getFundAmountRoubles(2) ;
        
        return (double) Math.round(amtFinal * 100) / 100;
	}
	
	public double getRestAmountInRoubles() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String expensesString = "Select * from expenses where id > (select system_value from t_user_system_params where userid = 1 and system_param_id = 2 )"
				+ "and operation_type_id in (select id from t_operation_type where is_income = 0)" ;
		
		String incomeString = "Select * from expenses where id > (select system_value from t_user_system_params where userid = 1 and system_param_id = 2 )"
				+ "and operation_type_id in (select id from t_operation_type where is_income = 1)" ;
		
		
		double amt = 0;
		
		double expAmt = 0;
		double incomeAmt = 0;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(expensesString);
        
        while(rs.next()){
        	expAmt = expAmt+rs.getDouble("amount");
        }
        
        rs = stat.executeQuery(incomeString);
        while(rs.next()){
        	incomeAmt = incomeAmt+rs.getDouble("amount");
        }
        rs.close();
        stat.close();
        conn.close();
        
        amt = this.getOpeningBalance() - expAmt + incomeAmt;
		
		return (double) Math.round(amt * 100) / 100; 
	}
	
	public double getTotalAmount(){
		return totalAmount;
	}
	
	public String getCurrencyType(int i) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		String query = "select * from currency where id = "+ i;
		String description = "";
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(query);
        
        while(rs.next()){
        	description = rs.getString("description");
        }
        rs.close();
        stat.close();
        conn.close();
        return description;
	}
	
	public double getFundAmount(int currencyId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		double amount = 0;
		
		String query = "select * from fund where currency_id = "+ currencyId;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(query);
        while(rs.next()){
        	amount += rs.getDouble("Amount");
        }
		
        rs.close();
        stat.close();
        conn.close();
		return amount;
	}
	public double getFundAmountRoubles(int currencyId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		double amount = 0;
		double price = 0;
		
		String query = "select * from fund where currency_id = "+ currencyId;
		String current_price = "select * from currency where id = "+ currencyId;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
        ResultSet rs=stat.executeQuery(query);
        while(rs.next()){
        	amount += rs.getDouble("Amount");
        }
        
        rs=stat.executeQuery(current_price);
        while(rs.next()){
        	price = rs.getDouble("price");
        }
        
        rs.close();
        stat.close();
        conn.close();
		return amount*price;
	}
	
	public void addExpensesData(ExpensesData ed) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String vQuery = "insert into expenses ( id, description, month_id, year_id, operation_type_id, update_date, amount) " +
		"values(get_id(1), '" + ed.getDescription() + "', " + ed.getMonthId() + ", " + ed.getYearId() + 
		", " + ed.getOperationType() + ", sysdate(), " + ed.getAmount() + ")";
				
				driver.setConnection();
				conn = (Connection) driver.getConnection();
				Statement stat=(Statement) conn.createStatement();
				stat.execute(vQuery);
				
		        stat.close();
		        conn.close();
	}
	
	public ArrayList<ExpensesData> getExpensesData(int y, int m) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<ExpensesData> expensesList = new ArrayList<>();
		String query = "select * from expenses where month_id = "+ m + " and year_id = " + y;
		
		driver.setConnection();
		conn = (Connection) driver.getConnection();
		Statement stat=(Statement) conn.createStatement();
		ResultSet rs=stat.executeQuery(query);
		while(rs.next()){
			
			Calendar cal = new GregorianCalendar();
        	cal.setTime(rs.getDate("update_date"));
			
			ExpensesData expData = new ExpensesData();
			expData.setId(rs.getInt("id"));
			expData.setOperationType(rs.getInt("operation_type_id"));
			expData.setDescription(rs.getString("description"));
			expData.setMonthId(rs.getInt("month_id"));
			expData.setYearId(rs.getInt("year_id"));
			expData.setAmount(rs.getDouble("amount"));
			expData.setUpdateDate(cal);
			
			expensesList.add(expData);
			
		}
		
		rs.close();
        stat.close();
        conn.close();
		
		return expensesList;
	}
	
	public void addFund(FundData fa) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String vQuery = "insert into fund (id, update_date, currency_id, amount, description, sale_price) " +
		"values(get_id(5), sysdate(), " +  fa.getCurrencyId() + ", " + fa.getAmount() + ", '" + fa.getDescription() + "', " 
				+ fa.getSalePrice() + ")";
				
				driver.setConnection();
				conn = (Connection) driver.getConnection();
				Statement stat=(Statement) conn.createStatement();
				stat.execute(vQuery);
				
		        stat.close();
		        conn.close();
	}
	
	
	

}
