/************************************************************************************
In this class we are creating various of bank accounts and making actions on them.

Name - Liron Cohen
ID - 206350399
************************************************************************************/
package Q2;
public class Main {
	public static void main(String [] args) {
	
		ServiceChargeChecking A = new ServiceChargeChecking("1","Liron Cohen","123456789",10000);
		NoServiceChargeChecking B = new NoServiceChargeChecking("2","Yakir Cohen","987654321",500,800);
		InterstChecking C = new InterstChecking("3","Shai Siton","135792468",20000);
		SavingsAccount D = new SavingsAccount("4","Hezi Luski","975318642",10000);
		HighInterestSavings E = new HighInterestSavings("5","Tal Sharvit","246813579",10000);
		
		//ServiceChargeChecking A
				System.out.println("\n***ServiceChargeChecking account***");
				System.out.println(A);
				System.out.println("\nmonthly management-->");
				A.monthlyManagement();
				System.out.println("\n" + A);
		
				
		//NoServiceChargeChecking B
				System.out.println("\n***NoServiceChargeChecking account***");
				System.out.println(B);
				System.out.println("\ntry to withdraw when my balance is under the minimum balance-->\n");
				try {
					B.withdraw(300);
				} 
				catch (IllegalBalance e) {
					System.out.println("\n" + e.getMessage());
				}
				System.out.println("\nmonthly management-->");
				B.monthlyManagement();
				System.out.println("\n" + B);
				
		//InterstChecking C
				System.out.println("\n***InterstChecking account***");
				System.out.println(C);
				System.out.println("\ntry to withdraw sum of money that is higher from my balance-->");
				try {
					C.withdraw(25000);
				} 
				catch (IllegalBalance e) {
					System.out.println("\n" + e.getMessage());
				}
				System.out.println("\ndeposit 555.555 in the account-->");
				C.deposit(555.555);
				System.out.println("\nmonthly management-->");
				C.monthlyManagement();
				System.out.println("\n" + C);
		
		//SavingsAccount D
				System.out.println("\n***SavingsAccount account***");
				System.out.println(D);
				System.out.println("\nmonthly management-->");
				D.monthlyManagement();
				System.out.println("\n" + D);
				
		//HighInterestSavings E
				System.out.println("\n***HighInterestSavings account***");
				System.out.println(E);
				System.out.println("\ndoes acoount number 1 and account number 5 are equal? --> " + E.equals((Object)A));
				System.out.println("\nchanging the name of the account");
				E.setName("Bar Cohen");
				System.out.println("\nmonthly management-->\n");
				E.monthlyManagement();
				System.out.println(E);
				
				
	}

}
