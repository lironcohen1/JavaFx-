/****************************************************************************************
In this class we also have a monthly fee that set by default or by the user 
the method monthly management is responsible for lowering the monthly fee every month
****************************************************************************************/
package Q2;
public class ServiceChargeChecking extends CheckingAccount{
	
	
	private final double DEFAULT_MONTHLY_FEE = 500;
	private double monthlyFee;

	
	public ServiceChargeChecking(String accountNumber, String name, String id, double balance){//constructor 
		super(accountNumber, name, id, balance);
		this.monthlyFee = DEFAULT_MONTHLY_FEE;
	}
	
	public ServiceChargeChecking(String accountNumber, String name, String id, double balance, double monthlyFee){//constructor
		super(accountNumber, name, id, balance);
		this.monthlyFee = monthlyFee;
	}
	
	/*********************************************************************************
	return the month fee gate
	*********************************************************************************/
	public double getMontlyFee() {
		return this.monthlyFee;
	}
	
	/*********************************************************************************
	set the month fee gate
	*********************************************************************************/
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	/*******************************************
	 this method is lowering the monthly fee
	*******************************************/
	public void monthlyManagement() {
		setBalance(getBalance() - monthlyFee);
	}
	
	/*******************************************************************************
	return the account details
	*******************************************************************************/
	public String toString(){
		
		return super.toString() + "\nMonth Fee: " + getMontlyFee();
	}
	
	/*******************************************************************************
	check if two accounts are equal
	*******************************************************************************/
	public boolean equals(Object obj){
		if(!(obj instanceof ServiceChargeChecking))
			return false;
			
		return super.equals(obj) && ((ServiceChargeChecking)obj).getMontlyFee() == this.monthlyFee;
			
	}
	
}
