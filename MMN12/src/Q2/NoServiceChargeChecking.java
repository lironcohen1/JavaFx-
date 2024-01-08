/****************************************************************************************
In this class we have a minimum balance which means that if the user want to withdraw 
sum of money but his balance is lower then the minimum balance of his account he can not 
make this withdraw
****************************************************************************************/
package Q2;
public class NoServiceChargeChecking extends CheckingAccount {
	
	
	private final double DEFAULT_MINIMUM_BALANCE = 500;
	protected double minimumBalance;

	
	public NoServiceChargeChecking(String accountNumber, String name, String id, double balance){//constructor 
		super(accountNumber, name, id, balance);
		this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
	}
	
	public NoServiceChargeChecking(String accountNumber, String name, String id, double balance, double minimumBalance){//constructor
		super(accountNumber, name, id, balance);
		this.minimumBalance = minimumBalance;
	}
	
	/****************************************************************************************
	return the minimum balance
	****************************************************************************************/
	public double getMinimumBalance() {
		return this.minimumBalance;
	}
	
	/****************************************************************************************
	set the minimum balance
	****************************************************************************************/
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	/*******************************************
	If our balance is under the minimum balance 
	the withdraw is not allowed
	*******************************************/
	public void withdraw(double sum) throws IllegalBalance{
		if(getBalance()>=getMinimumBalance()) {
			super.withdraw(sum);
		}
		else {
			System.out.println("you can not make this witdraw of (" + sum + ") your balance is under the minimum balance");
		}
	}
	
	/****************************************************************************************
	The NoServiceChargeChecking class is not an abstract class so we need to implement the 
	monthlyManagement method but we do not have a monthly fee or interest in this class 
	so in this class this method will not do anything
	****************************************************************************************/
	public void monthlyManagement() {

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
		if(!(obj instanceof NoServiceChargeChecking))
			return false;
			
		return super.equals(obj) &&
				((NoServiceChargeChecking)obj).getMinimumBalance() == this.minimumBalance;
			
	}

}
