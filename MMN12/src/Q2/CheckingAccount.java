/***************************************************************
In this class we can also write a checks 
***************************************************************/
package Q2;
public abstract class CheckingAccount extends BankAccount {
	
	
	public CheckingAccount(String accountNumber, String name, String id, double balance){//constructor
		super(accountNumber, name, id, balance);
	}
	
	/******************************************************************
	in this method we can write a check if the check is bigger 
	from the balance we will throw exception
	******************************************************************/
	public void writeCheck(double check) throws IllegalBalance{
		
		if(check > getBalance())
			throw new IllegalBalance("Error! you can not write a check in this sum (" + check +") your balance is not enough");
		
		setBalance(getBalance() - check);
	}

}
