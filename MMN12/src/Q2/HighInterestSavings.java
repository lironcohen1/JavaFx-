/*********************************************************************************
In this class we have an account with interest and with minimum balance.
*********************************************************************************/
package Q2;
public class HighInterestSavings extends SavingsAccount{
	
	private final double DEFAULT_INTERST = 0.05;//5% interest
	private final double DEFAULT_MINIMUM_BALANCE = 500;
	private double interst;
	private double minimumBalance;
	
	
	public HighInterestSavings(String accountNumber, String name, String id, double balance){//constructor
		super(accountNumber, name, id, balance);
		this.interst = DEFAULT_INTERST;
		this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
	}
	
	public HighInterestSavings(String accountNumber, String name, String id, double balance, double interst, double minimumBalance){//constructor
		super(accountNumber, name, id, balance);
		this.interst = interst;
		this.minimumBalance = minimumBalance;
	}
	
	/*********************************************************************************
	return the minimum balance
	*********************************************************************************/
	public double getMinimumBalance() {
		return this.minimumBalance;
	}
	
	/*********************************************************************************
	set the minimum balance
	*********************************************************************************/
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	/*******************************************************************************
	return the account details
	*******************************************************************************/	
	public String toString(){
		
		return super.toString() + "\nMinimum Balance: " + getMinimumBalance();
	}
	
	/*******************************************************************************
	check if two accounts are equal
	*******************************************************************************/
	public boolean equals(Object obj){
		if(!(obj instanceof HighInterestSavings))
			return false;
			
		return super.equals(obj) &&
				((HighInterestSavings)obj).getMinimumBalance() == this.minimumBalance;
			
	}

}
