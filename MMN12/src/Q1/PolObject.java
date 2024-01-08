/*****************************************************
this class create object that have promoter and exponent
and the polynome is build by this object by adding to the polynome 
another polObjcet that the user create
*****************************************************/
package Q1;
public class PolObject {
	
	private double promoter;
	
	private int exponent;
	
	public PolObject(double promoter, int exponent){//constructor
		this.promoter = promoter;
		this.exponent = exponent;
		
	}
	
	/*******************************
	 return the polynome promoter
	*******************************/
	public double getPromoter() {
		return this.promoter;
	}
	
	/*******************************
	 return the polynome exponent
	*******************************/
	public int getExponent() {
		return this.exponent;
	}
	
	
}
