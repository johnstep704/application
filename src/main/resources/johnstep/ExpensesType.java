package johnstep;

import java.util.ArrayList;
import java.util.Collection;

import ifc.ExpensesTypeIfc;


public class ExpensesType implements ExpensesTypeIfc {
	
	int id;
	String Description;
	
	Collection<ExpensesTypeIfc> et = new ArrayList<ExpensesTypeIfc>();
	
	public ExpensesType(){
		super();
	}
	
	public ExpensesType(int id, String dsc){
		this.setId(id);
		this.setDescription(dsc);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	

}
