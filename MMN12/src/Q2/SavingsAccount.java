/*********************************************************************************
In this class we have an account with interest that in every month get from 
the bank sum of money according to his balance and the interest percentage.
*********************************************************************************/
package Q2;
public class SavingsAccount extends BankAccount{
	
	private final double DEFAULT_INTERST = 0.025;//2.5% interest
	private double interst;
	
	public SavingsAccount(String accountNumber, String name, String id, double balance){//constructor
		super(accountNumber, name, id, balance);
		this.interst = DEFAULT_INTERST;
	}
	
	public SavingsAccount(String accountNumber, String name, String id, double balance, double interst){//constructor
		super(accountNumber, name, id, balance);
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
		if(!(obj instanceof SavingsAccount))
			return false;
			
		return super.equals(obj) &&
				((SavingsAccount)obj).getInterst() == this.interst;
			
	}

}
