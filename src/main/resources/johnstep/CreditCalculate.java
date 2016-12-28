package johnstep;

public class CreditCalculate {
	
	String str = "";
	Double overpaid = (double) 0;
	
	Double mPayment = (double) 0;
	
	
	public CreditCalculate(){
		super();
	}
	
	public CreditCalculate(Double a, int m, Double p ){
		
		Double s;
		s= a;
		
		int month = m;
		Double perc = p;
				
		Double  pPerc = (perc/100)/12;
		Double pPlus  = 1+pPerc;
		Double y = Math.pow(pPlus, month);
		
		Double f1 = y-1;
		Double f2 = pPerc/f1;
		Double f3 = pPerc+f2;
		
		//System.out.println("f1 = "+f1);
		//System.out.println("f2 = "+f2);
		//System.out.println("f3 = "+f3);
		
		mPayment = s*f3;
		//System.out.println("MPayment = "+ mPayment);
		overpaid = (mPayment*m)-a;
		
		
		

		}


	String getStr(){
		return str;
	}
	
	Double getOverpaid(){
		return overpaid;
	}
	
	Double getMPayment(){
		return mPayment;
	}
	
	public String getOverpaidDesc(){
		String s = String.format("%.2f", overpaid);
		return s;
	}
	
	public String getMpaymentDesc(){
		String s = String.format("%.2f", mPayment);
		return s;
	}

		
}
