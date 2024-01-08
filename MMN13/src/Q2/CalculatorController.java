/******************************************************************************************
In this program we make an user interface of calculator.

Name - Liron Cohen
ID - 206350399
******************************************************************************************/
package Q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class CalculatorController {

    @FXML
    private Label result;
    
    
    String resultStr="",lastAction="";
    double sum,newNumber=0;
    
    enum flag {NUMBER,EQUAL,ACTION}//flag options to know what was the last type button pressed
    flag currFlag=null;//currFlag save the last state that we was on 
    
    
    public void initialize() {
    	result.setText("start...");
    	sum=0;
    	resultStr="";
    	lastAction="";
    }
    

    //Concatenation of the number 0 to the total number the user has typed so far
    @FXML
    void numberZeroPressed(ActionEvent event) {
    	numberHandler("0");
    }
    
    //Concatenation of the number 1 to the total number the user has typed so far
    @FXML
    void numberOnePressed(ActionEvent event) {
    	numberHandler("1");
    }
    
    //Concatenation of the number 2 to the total number the user has typed so far
    @FXML
    void numberTwoPressed(ActionEvent event) {
    	numberHandler("2");
    }
    
    //Concatenation of the number 3 to the total number the user has typed so far
    @FXML
    void numberThreePressed(ActionEvent event) {
    	numberHandler("3");
    }
    
    //Concatenation of the number 4 to the total number the user has typed so far
    @FXML
    void numberFourPressed(ActionEvent event) {
    	numberHandler("4");
    }
    
    //Concatenation of the number 5 to the total number the user has typed so far
    @FXML
    void numberFivePressed(ActionEvent event) {
    	numberHandler("5");
    }
    
    //Concatenation of the number 6 to the total number the user has typed so far
    @FXML
    void numberSixPressed(ActionEvent event) {
    	numberHandler("6");
    }
    
    //Concatenation of the number 7 to the total number the user has typed so far
    @FXML
    void numberSevenPressed(ActionEvent event) {
    	numberHandler("7");
    }
    
    //Concatenation of the number 8 to the total number the user has typed so far
    @FXML
    void numberEightPressed(ActionEvent event) {
    	numberHandler("8");
    }
    
    //Concatenation of the number 9 to the total number the user has typed so far
    @FXML
    void numberNinePressed(ActionEvent event) {
    	numberHandler("9");
    }
    
    //Concatenation of "." to the total number the user has typed so far
    @FXML
    void dotPressed(ActionEvent event) {
    	if(currFlag==flag.EQUAL)
    		initialize();
    	
    	if(resultStr.contains(".") || resultStr.equals("-"))//if the user already press on the dot button in this current number
    		return;
    	if(resultStr.equals("") || resultStr.equals("start...")) {//if the first thing that the user press is dot 
    		resultStr="0.";
    	}
    	else
    		resultStr += ".";
    	result.setText(resultStr);
    	currFlag = flag.NUMBER;
    }
    
    //change the number sign
    @FXML
    void signPressed(ActionEvent event) {
    	if(currFlag==flag.EQUAL) {//if the last action is equal button so we take the result and multiple it in -1
    		sum*=-1;
    		printResult();
    		return;
    	}
    	else if(currFlag == flag.NUMBER) {//if the last action was a number button we add or remove the "-" from the resultStr 
    		if(resultStr.contains("-"))
    			resultStr=resultStr.substring(1);
    		else
    			resultStr="-" + resultStr;
    		result.setText(resultStr);
    		return;
    	}
    	
    	if(resultStr.equals("")) //if the user pressed "-" before he pressed any number
    		resultStr="-";
    	
    	else if(resultStr.equals("-"))////if the user pressed "-" before he pressed any number
    		resultStr="";
    	
    	result.setText(resultStr);
    		
    	
    }

    //doing the plus action
    @FXML
    void plusPressed(ActionEvent event) {
    	if(currFlag==null) {//if the first thing that the user do was to press on action button
    		return;
    	}
    	if(currFlag==flag.EQUAL) {//if the user pressed action button right after he pressed the equal button
    		actionAfterEqualButton("+");
    		return;
    	}
    	if(currFlag==flag.ACTION) {//if the user pressed action button in a row so we take the last action button that he typed
    		lastAction = "+";
    		return;
    	}
    		
    	actionHandler("+");

    }
    
    //doing the minus action
    @FXML
    void minusPressed(ActionEvent event) {
    	if(currFlag==null) {//if the first thing that the user do was to press on action button
    		return;
    	}
    	if(currFlag==flag.EQUAL) {//if the user pressed action button right after he pressed the equal button
    		actionAfterEqualButton("-");
    		return;
    	}
    	if(currFlag==flag.ACTION ) {//if the user pressed action button in a row so we take the last action button that he typed
    		lastAction = "-";
    		return;
    	}
    	actionHandler("-");
    }
    
    //doing the multiplication action
    @FXML
    void multiplicationPressed(ActionEvent event) {
    	if(currFlag==null) {//if the first thing that the user do was to press on action button
    		return;
    	}
    	if(currFlag==flag.EQUAL) {//if the user pressed action button right after he pressed the equal button
    		actionAfterEqualButton("*");
    		return;
    	}
    	if(currFlag==flag.ACTION ) {//if the user pressed action button in a row so we take the last action button that he typed
    		lastAction = "*";
    		return;
    	}
    	
    	actionHandler("*");
    }
    
    //doing the division action
    @FXML
    void divisionPressed(ActionEvent event) {
    	if(currFlag==null) {//if the first thing that the user do was to press on action button
    		return;
    	}
    	if(currFlag==flag.EQUAL) {//if the user pressed action button right after he pressed the equal button
    		actionAfterEqualButton("/");
    		return;
    	}
    	if(currFlag==flag.ACTION ) {//if the user pressed action button in a row so we take the last action button that he typed
    		lastAction = "/";
    		return;
    	}
    	
    	actionHandler("/");
    }

    //when equal button is pressed the result will be on the screen
    @FXML
    void equalButtonPressed(ActionEvent event) {
    	//if the first thing that the user do was to press on equal button or he pressed on the action button in a row
    	if(currFlag==null || currFlag==flag.EQUAL) {
    		return;
    	}
    	if(currFlag==flag.ACTION) {//if the user pressed an action button and right after that pressed on the equal button
    		return;
    	}
    	if(dividingZeroChecking())//if the user divide in zero
    		return;
    	
    	
    	//calculate and printing the result
    	newNumberUpdate();
    	sumUpdate(lastAction);
    	printResult();
    	currFlag=flag.EQUAL;
    }
    
    //update the new number that the user entered
    public void newNumberUpdate(){
    	newNumber = Double.parseDouble(resultStr);
    	
    }
    
    //update the total sum according to the action 
    public void sumUpdate(String lastAction) {
    	switch(lastAction) {
    		case "+": 
    			sum+=newNumber;
    			break;
    		case "-": 
    			sum-=newNumber;
    			break;
    		case "*": 
    			sum*=newNumber;
    			break;
    		case "/": 
    			sum/=newNumber;
    			break;
    		default:
    			sum=newNumber;
    			break;
    			
    	}
    }
    
    //printing the result we get
    public void printResult() {
    	if(sum%1==0){//this is an integer number
    		resultStr = (int)sum + "";
    		result.setText(resultStr);
    	}
    	else{//this is a float number
    		resultStr = sum + "";
    		result.setText(resultStr);
    		
    	}
    	
    	
    }
    
    //when action button is pressed we update the sum according to the button that is pressed
    public void actionHandler(String currAction) {
    	newNumberUpdate();
    	sumUpdate(lastAction);
    	lastAction = currAction;
    	printResult();
    	resultStr="";
    	currFlag=flag.ACTION;
    	
    }
    //when the user pressed an equal button and right after an action button so we need to make the new action on the last result
    public void actionAfterEqualButton(String currAction) {
		lastAction = currAction;
		resultStr="";
		currFlag=flag.ACTION;
    }
    
    //this function handled with the number that the user pressed
    public void numberHandler(String number) {
    	if(currFlag==flag.EQUAL)//if last pressed was the equal button so we want to start a new calculate and not save the last result
    		initialize();
    	
    	resultStr += number;
    	result.setText(resultStr);
    	currFlag = flag.NUMBER;
    	
    }
    
    //checking if the user divide in zero
    public boolean dividingZeroChecking() {
    	if(Double.parseDouble(resultStr)==0 && lastAction.equals("/")){//if the user divide in zero we will return true
    		initialize();
    		currFlag=null;
    		result.setText("ERROR");
    		return true;
    	}
    	return false;
    }

}
