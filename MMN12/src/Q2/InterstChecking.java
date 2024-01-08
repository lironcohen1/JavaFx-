/*********************************************************************************
In this class we have an account with interest that in every month get from 
the bank sum of money according to his balance and the interest percentage 
but this bank account have also a minimum balance that is higher from 
the minimum balance that is in the NoServiceChargeChecking class. 
*********************************************************************************/
package Q2;
public class InterstChecking extends NoServiceChargeChecking {
	
	private final double DEFAULT_MINIMUM_BALANCE = 1000;
	private final double DEFAULT_INTERST = 0.025;//2.5%
	private double interst;
	
	public InterstChecking(String accountNumber, String name, String id, double balance){//constructor 
		super(accountNumber, name, id, balance);
		this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
		this.interst = DEFAULT_INTERST;
		
	}
	
	public InterstChecking(String accountNumber, String name, String id, double balance, double minimumBalance, double interst){//constructor
		super(accountNumber, name, id, balance, minimumBalance);
		this.interst = interst;
	}
	
	/*********************************************************************************
	return the interest gate
	*********************************************************************************/
	public double getInterst() {
		return this.interst;
	}
	
	/*********************************************************************************
	set the interest gate
	*********************************************************************************/
	public void setInterst(double interst) {
		this.interst = interst;
	}
	
	/**********************************************************
	This method calculate the money that the user should get 
	according to his balance and the interest percentage
	**********************************************************/
	public double interstCalculate(){
		return getBalance()*getInterst();
		
	}
	/**********************************************************
	This method adding to the balance that user should get
	according to his balance and the interest percentage
	**********************************************************/
	public void monthlyManagement() {
		setBalance(getBalance() + interstCalculate());
	}
	
	/*******************************************************************************
	return the account details
	*******************************************************************************/
	public String toString(){
		
		return super.toString() + "\nInterest: " + getInterst();
	}
	
	/*******************************************************************************
	check if two accounts are equal
	*******************************************************************************/
	public boolean equals(Object obj){
		if(!(obj instanceof InterstChecking))
			return false;
			
		return super.equals(obj) &&
				((InterstChecking)obj).getInterst() == this.interst;
			
	}

}
