/*******************************************************************************
This class is the father of all our classes that we will make in this program 
we can make simple action on the account like change the number account or the name 
or the id and also we can deposit to the account or withdraw from the account
*******************************************************************************/
package Q2;
public abstract class BankAccount {
	
	private String accountNumber;
	private String name;
	private String id;
	private double balance;
	
	
	public BankAccount(String accountNumber, String name, String id, double balance){//constructor
		this.accountNumber=accountNumber;
		this.name=name;
		this.id=id;
		this.balance=balance;
	}
	
	/*******************************************************************************
	return the account number
	*******************************************************************************/
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	/*******************************************************************************
	set the account number
	*******************************************************************************/
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	/*******************************************************************************
	return the account name
	*******************************************************************************/
	public String getName() {
		return this.name;
	}
	
	/*******************************************************************************
	set the account name
	*******************************************************************************/
	public void setName(String name) {
		this.name=name;
	}
	
	/*******************************************************************************
	return the account ID
	*******************************************************************************/
	public String getId() {
		return this.id;
	}
	
	/*******************************************************************************
	set the account ID
	*******************************************************************************/
	public void setId(String id) {
		this.id=id;
	}
	
	/*******************************************************************************
	return the account balance
	*******************************************************************************/
	public double getBalance() {
		return this.balance;
	}
	
	/*******************************************************************************
	set the account balance
	*******************************************************************************/
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	/******************************************************************
	this method gets sum of money and add it to the balance
	******************************************************************/
	public void deposit(double sum) {
		setBalance(getBalance() + sum);
	}
	
	/******************************************************************
	this method gets sum of money that the user want to withdraw 
	if he have this sum of money in the balance he will get the money and the balance will update
	other we will throw exception
	******************************************************************/
	public void withdraw(double sum) throws IllegalBalance{
		double temp;
		temp = getBalance() - sum;
		if(temp<0)
			throw new IllegalBalance("Error! you can not withdraw this sum (" + sum + ") your balance is not enough");
		
		setBalance(temp);
		
	}
	
	/*******************************************************************************
	abstract method of month manage
	*******************************************************************************/
	public abstract void monthlyManagement();
	
	/*******************************************************************************
	return the account details
	*******************************************************************************/	
	public String toString(){
		
		return "Account Number: " + getAccountNumber() +  "\nName: " + getName()
			+ "\nID: " + getId() + "\nBalance: " + getBalance();
	}
	
	
	/*******************************************************************************
	check if two accounts are equal
	*******************************************************************************/
	public boolean equals(Object obj){
		if(!(obj instanceof BankAccount))
			return false;
			
		return ((BankAccount)obj).getAccountNumber().equals(this.getAccountNumber()) &&
				((BankAccount)obj).getName().equals(this.getName()) &&
				((BankAccount)obj).getId().equals(this.getId()) &&
				((BankAccount)obj).getBalance() == this.getBalance();
			
	}
	
	
	
}
