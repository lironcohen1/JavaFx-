/**************************************************************************
In this program the user enter 2 polynomes 
and we make actions on those 2 polynomes like 
adding, subtraction and derivatives.
In this class we also have method that gets input from the user 
and after we get 2 polynomes from the user we run on them various of methods


Name - liron cohen
**************************************************************************/



package Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String [] args) throws Exception {
        Polynome p,q;
		System.out.println("hello! you need to enter 2 polynomials so please start to enter the first polynome\n"
				+ "which calls p and you do it in the next way you will enter each time the promoter first which is a Real\n"
				+ "number and after that you will enter the exponent number which is Natural number (for examaple->1.0 2)\n"
				+ "when you finish please enter stop");
		
		p = PolynomeInput();//getting first polynome
		System.out.println("now please enter the second Polynome");
		q = PolynomeInput();//getting second polynome
		System.out.println("p = "+ p);
		System.out.println("q = "+ q);
		System.out.println("p+q = " + p.plus(q));
		System.out.println("p-q = " + p.minus(q));
		System.out.println("p' = " + p.derivative());
		System.out.println("q' = " + q.derivative());
		System.out.println("Does p equal q? ---> " + (p.equals(q) ? "Yes": "No"));
		
		
		
	}
	
	
	
	
	/*************************************************************
	 this method is responsible to get from the user the values 
	 of the polynome and create it.
	 *************************************************************/
	public static Polynome PolynomeInput() throws Exception{
		Scanner scanner = new Scanner(System.in);
		//making arrayList because we dont know the size of the polynome
		ArrayList<Double> Promoter = new ArrayList<>();
        ArrayList<Integer> Exponent = new ArrayList<>();
		while(true) {
			String input = scanner.nextLine();
			if(input.equals("stop"))
				break;
			//getting 2 numbers one for promoter and one for the exponent
			String [] divide = input.split(" ");
			Promoter.add(Double.parseDouble(divide[0]));
			Exponent.add(Integer.parseInt(divide[1]));
		}
		double [] arrPromoter = new double[Promoter.size()];
		int [] arrExponent = new int[Exponent.size()];
		//putting the input of the user into two arrays one for promoter and one for exponent
		for(int i=0;i<arrPromoter.length;i++) {
			arrPromoter[i] = Promoter.get(i);
			arrExponent[i] = Exponent.get(i);
		}
		
		
		return new Polynome(arrPromoter,arrExponent);

	}
}
