/***************************************************************************************
This is the polynome class which we create here 
the polynome and we also have in this class methods that make actions on the polynomes

***************************************************************************************/
package Q1;


import java.util.ArrayList;
import java.util.Scanner;

public class Polynome {
	

	private ArrayList<PolObject> polynome;
	
	public Polynome(double [] Promoter , int [] Exponent) throws Exception{//constructor
		if(Promoter.length != Exponent.length) {
			throw new Exception();
		}
		
		polynome = new ArrayList<PolObject>(Promoter.length);
		
		for(int i = 0 ; i<Promoter.length ; i++) {
			if(Promoter[i]==0)
				continue;
			polynome.add(new PolObject(Promoter[i],Exponent[i]));  
		}
		
		sort(polynome);
		
	}
	
	
	public Polynome() {//constructor
		polynome = new ArrayList<PolObject>(0);
	}
	
	

	
	/*******************************************************************************************************************
	 this method sort the ArrayList and for members that their exponent is equal we will add sum them up
	*******************************************************************************************************************/
	public void sort(ArrayList<PolObject> polynome) {
		PolObject temp;
		int i,j,exponent;
		double promoter;
		// sorting the arrays, in each external loop we find the lowest number in the array from i to the end
		for(i=0 ; i<polynome.size();i++) {
			for(j=i+1; j<polynome.size();j++) {
				if(polynome.get(i).getExponent()<polynome.get(j).getExponent()) {
					temp = polynome.get(i);
					polynome.set(i, polynome.get(j));
					polynome.set(j, temp);
				}
					
			}
		}
		
		/*if the user enter the polynome with same exponent we find those two members and sum up 
		 their promoters */
		i=0;
		while(i+1<polynome.size()) {
			if(polynome.get(i).getExponent()==polynome.get(i+1).getExponent()) {
				exponent = polynome.get(i).getExponent();
				promoter = polynome.get(i).getPromoter() + polynome.get(i+1).getPromoter();
				polynome.set(i, new PolObject(promoter,exponent));
				polynome.remove(i+1);
				continue;	
			}
			i++;
			
		}
	}
	
	/**************************************************************************************
	 this function is sum up two polynomes and return a new polynome that is the sum.
	 **************************************************************************************/
	public Polynome plus(Polynome other) {
		int indexOther=0 , indexThis=0;
		Polynome A = new Polynome();
		PolObject temp;
		double promoter;
		/*we are moving on the two arrays of the polynome if we find that their polobject exponent is equal we will sum up their promoter 
		and add it to the new polynome if their exponent is not equal we just add the polobject who has the bigger exponent to the new array 
		we do this until at least we move on all of the array that represent the polynome  */
		
		while(indexOther<other.polynome.size() && indexThis<this.polynome.size()) {
			if(other.polynome.get(indexOther).getExponent()==this.polynome.get(indexThis).getExponent()) {
				promoter = other.polynome.get(indexOther).getPromoter() + this.polynome.get(indexThis).getPromoter();
				if(promoter!=0) {//if the promoter equal to zero we dont enter it to the polynome
					temp = new PolObject(promoter,other.polynome.get(indexOther).getExponent());
					A.polynome.add(temp);
				}
				indexOther++;
				indexThis++;
			}
			else if(other.polynome.get(indexOther).getExponent()>this.polynome.get(indexThis).getExponent()) {
				A.polynome.add(other.polynome.get(indexOther));
				indexOther++;
			}
			else {
				A.polynome.add(this.polynome.get(indexThis));
				indexThis++;
			}
		}
		
		/*if we don to look on one polynome and did not finish the other we will concatenate what left of this polynome*/
		
		while(indexOther<other.polynome.size()) {
			A.polynome.add(other.polynome.get(indexOther));
			indexOther++;
		}
		
		while(indexThis<this.polynome.size()) {
			A.polynome.add(this.polynome.get(indexThis));
			indexThis++;
		}
		
		return A;
		
	}
	
	
	/**************************************************************************************
	 this function is subtract two polynomes and return a new polynome that is the subtract.
	 **************************************************************************************/
	public Polynome minus(Polynome other) {
		Polynome oppositeOther = new Polynome();
		double promoter;
		int exponent;
		// we get the opposite of the polynome --> Polynome other * (-1)
		for(int i=0;i<other.polynome.size();i++) {
			promoter = other.polynome.get(i).getPromoter() * (-1);
			exponent = other.polynome.get(i).getExponent();
			oppositeOther.polynome.add(new PolObject(promoter,exponent));		
		}
		
		//a - b equal to a + (-b)
		return this.plus(oppositeOther);
		
	}
	
	
	/**************************************************************************************
	 this function finds the derivative of the polynome
	 **************************************************************************************/
	public Polynome derivative() {
		Polynome A = new Polynome();
		int exponent;
		double promoter;
		for(int i=0;i<this.polynome.size();i++) {
			exponent = this.polynome.get(i).getExponent();
			if(exponent==0)//if exponent equal to zero so the derivative of it will be zero
				continue;
			//derivative laws
			promoter = this.polynome.get(i).getPromoter() * exponent;
			exponent--;
			A.polynome.add(new PolObject(promoter,exponent));
		}
			
		return A;
		
	}
	/**************************************************************************************
	 this method return a string the represent the polynome
	 ***I limited the float number to show only one digit after the point***
	 **************************************************************************************/
	public String toString() {
		String str="",limitPromoter="";
		int exponent;
		double promoter;
		for(int i=0;i<this.polynome.size();i++) {
			promoter = this.polynome.get(i).getPromoter();
			limitPromoter = String.format("%.1f", promoter);//limit the promoter to handle the Floating-Point Precision
			exponent = this.polynome.get(i).getExponent();
				if(exponent==0){//if exponent equal to zero we write only the number without adding the "x"
					if(promoter>0 && i!=0)//i!=0 because if this is the first term in the polynome we wont put "+" before the number
						str += "+";
					str += "" + limitPromoter;
					continue;
				}
				if(exponent==1){//if the exponent equal to 1 we write our number * x
					if(promoter>0 && i!=0)
						str += "+";
					str += limitPromoter + "x";
					continue;
				}
				if(promoter>0 && i!=0)
					str += "+";
				str += limitPromoter + "x^" + exponent;
			
			}
		if(str.length() == 0)//if str is empty its because it equal to zero
			str = "0";
		return str;
		
	}
	/**************************************************************************************
	 this method check if two polynomes are equal
	 **************************************************************************************/
	public boolean equals(Object obj) {
		if(!(obj instanceof Polynome))
			return false;
		//if the number of terms of the polynomes is different they are not equal
		if(((Polynome)obj).polynome.size()!=this.polynome.size())
			return false;
		
		for(int i=0 ; i<this.polynome.size();i++) {
			if(((Polynome)obj).polynome.get(i).getPromoter()!=this.polynome.get(i).getPromoter())
				return false;
			if(((Polynome)obj).polynome.get(i).getExponent()!=this.polynome.get(i).getExponent())
				return false;
		}
		
		return true;
		
	}

}
