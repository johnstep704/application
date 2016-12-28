package johnstep;

public class Pars {
	
	public Pars(){
		super();

	}
	
	public Double getResultStr(String s) {

	    double amount = 0;
	    double amtPlus = 0;


	    String firstSimbol = s.substring(0,1);

	    if(firstSimbol.equals("=")){

	        String sNumber = "";

	        char [] myChar = s.toCharArray ();
	        for (int i=0 ; i<myChar.length;i++ ){


	            if(Character.isDigit(myChar[i])==true && i!=myChar.length){

	                String chStr = Character.toString(myChar[i]);

	                sNumber = sNumber.concat(chStr);

	            }
	            if(Character.toString(myChar[i]).equals("-")){

	                amtPlus = Double.parseDouble(sNumber);
	                amount = amount+amtPlus;

	                sNumber = "-";

	            }
	            if(Character.toString(myChar[i]).equals("+")){

	                amtPlus = Double.parseDouble(sNumber);
	                amount = amount+amtPlus;

	                sNumber = "";

	            }



	        }

	        amtPlus = Double.parseDouble(sNumber);
	        amount = amount+amtPlus;




	    } else{
	        amount = Double.parseDouble(s);
	    }


	    return amount;
	}

}
