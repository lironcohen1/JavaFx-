/****************************************************************
In this program we make a trivia game 

Name - Liron Cohen
****************************************************************/
package Q1;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.Collections;
import java.util.Optional;

public class GameController {
	
    @FXML
    private Label questionLable;

    @FXML
    private Button buttonNumberOne;

    @FXML
    private Button buttonNumberTwo;

    @FXML
    private Button buttonNumberThree;

    @FXML
    private Button buttonNumberFour;

    @FXML
    private Label answerLable;
    
    ArrayList<String> randomAnswers = new ArrayList<>();//ArrayList for use the function shuffle to make the 4 answers randomized
    //create the colors green and red for the buttons when the user choose correct or false answer
    Background greenColor = new Background(new BackgroundFill(Color.GREEN,null ,null));
    Background redColor = new Background(new BackgroundFill(Color.RED,null ,null));
    Background regularColor;
    //index for the questions that arranged in array
    int index,CorrectAnswerCounter;
    //flag for the user can only choose one answer in any question if flag equal false so the user still did not choose answer if the flag equals true so he choose
    boolean flag;
    
  //creating 5 questions and put them in array
	Questions firstQuestion = new Questions("Originally, Amazon only sold what kind of product?","Books","Televisions","Food","Cell Phones");
	Questions secondQuestion = new Questions("How many times has the Mona Lisa been stolen?","One","Five","Three","Eight");
	Questions thirdQuestion = new Questions("In what year did the Titanic sink?","1912","1900","1921","1915");
	Questions fourthQuestion = new Questions("Until 1981, Greenland was a colony of which country?","Denmark","Spain","France","Germany");
	Questions fifthQuestion = new Questions("What year was the iPhone first released in?","2007","2005","2009","2010");
	Questions arrayQusetions [] = {firstQuestion,secondQuestion,thirdQuestion,fourthQuestion,fifthQuestion};
    
    public void initialize() {
        
    	index=0;
    	CorrectAnswerCounter=0;
        flag=false;
        clearAnswersColor();
        answerLable.setText("");
        
    	//getting the regular color of the buttons the initialized their color in any new question
    	regularColor = buttonNumberOne.getBackground();
    	
    	questionLable.setText(arrayQusetions[index].getQuestion());
    	//shuffle the answers and put them on the buttons
    	randomAnswers = shuffleAnswers(arrayQusetions[index]);
    	setAnswersOnButtons(randomAnswers);
    	

    }

   

    @FXML
    void pressedAnswerOne(ActionEvent event) {
    	if(flag)
    		return;
    	flag=true;//prevent from the user to press the other buttons answer until he proceed to the next question
    	
    	//if the user choose correct answer
    	if(arrayQusetions[index].getCorrectAnswer().equals(buttonNumberOne.getText())) {
    		buttonNumberOne.setBackground(greenColor);
        	answerLable.setText("Correct !!! :)");
    		answerLable.setTextFill(Color.GREEN);
    		CorrectAnswerCounter++;
    	}
    	else {//if the user choose wrong answer
    		buttonNumberOne.setBackground(redColor);
        	answerLable.setText("Wrong answer :(");
    		answerLable.setTextFill(Color.RED);
    		discoverCorrectAnswer();
    		
    	}
    		
    }
    
    
    @FXML
    void pressedAnswerTwo(ActionEvent event) {
    	if(flag)
    		return;
    	flag=true;//prevent from the user to press the other buttons answer until he proceed to the next question
    	
    	//if the user choose correct answer
    	if(arrayQusetions[index].getCorrectAnswer().equals(buttonNumberTwo.getText())) {
    		buttonNumberTwo.setBackground(greenColor);
        	answerLable.setText("Correct !!! :)");
    		answerLable.setTextFill(Color.GREEN);
    		CorrectAnswerCounter++;
    	}
    	else {//if the user choose wrong answer
    		buttonNumberTwo.setBackground(redColor);
        	answerLable.setText("Wrong answer :(");
    		answerLable.setTextFill(Color.RED);
    		discoverCorrectAnswer();
    		
    	}

    }
    

    @FXML
    void pressedAnswerThree(ActionEvent event) {
    	if(flag)
    		return;
    	flag=true;//prevent from the user to press the other buttons answer until he proceed to the next question
    	
    	//if the user choose correct answer
    	if(arrayQusetions[index].getCorrectAnswer().equals(buttonNumberThree.getText())) {
    		buttonNumberThree.setBackground(greenColor);
        	answerLable.setText("Correct !!! :)");
    		answerLable.setTextFill(Color.GREEN);
    		CorrectAnswerCounter++;
    	}
    	else {//if the user choose wrong answer
    		buttonNumberThree.setBackground(redColor);
        	answerLable.setText("Wrong answer :(");
    		answerLable.setTextFill(Color.RED);
    		discoverCorrectAnswer();
    		
    	}

    }
    
    
    @FXML
    void pressedAnswerFour(ActionEvent event) {
    	if(flag)
    		return;
    	flag=true;//prevent from the user to press the other buttons answer until he proceed to the next question
    	
    	//if the user choose correct answer
    	if(arrayQusetions[index].getCorrectAnswer().equals(buttonNumberFour.getText())) {
    		buttonNumberFour.setBackground(greenColor);
        	answerLable.setText("Correct !!! :)");
    		answerLable.setTextFill(Color.GREEN);
    		CorrectAnswerCounter++;
    	}
    	else {//if the user choose wrong answer
    		buttonNumberFour.setBackground(redColor);
        	answerLable.setText("Wrong answer :(");
    		answerLable.setTextFill(Color.RED);
    		discoverCorrectAnswer();
    		
    	}

    }
    

    @FXML
    void pressedNextQuestion(ActionEvent event) {
    	flag=false;//when the user move to the next question we open the ability to press on the buttons
    	index++;
    	if(index>=arrayQusetions.length) {//when the user finish to answer all the questions
    		int score = (CorrectAnswerCounter*100)/arrayQusetions.length;//calculate the score
    		Alert finish = new Alert(Alert.AlertType.NONE);
    		finish.setTitle("END GAME");
    		// create a vbox to arrange the score in the top and the picture under
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(new javafx.scene.control.Label("your score is " + score + "\n\n\n"),new ImageView(this.getClass().getResource("picture.png").toString()));
            finish.getDialogPane().setContent(vBox);
          
            ButtonType StaraOverButton = new ButtonType("Start Over");
            ButtonType exitButton = new ButtonType("Exit");
            finish.getButtonTypes().setAll(StaraOverButton,exitButton);
            

            //show the pop up and wait for the answers
            Optional<ButtonType> result = finish.showAndWait();
            if(result.get() == StaraOverButton) {
            	initialize();
            }
            else { //close the the program when the user want to stop the program
            	Game.myStage.close();
            	return;
            }
    		
    		
    	}
    		
    	clearAnswersColor();//set the regular button color for the next question
    	answerLable.setText("");//clear the filed that tell if the user is right or wrong
    	questionLable.setText(arrayQusetions[index].getQuestion());//put the new question
        //shuffle the answers and put them on the buttons
        randomAnswers = shuffleAnswers(arrayQusetions[index]);
        setAnswersOnButtons(randomAnswers);
        	

    }
    
    
    //This method shuffle the 4 option answers to make them random
    public ArrayList<String> shuffleAnswers(Questions question){
    	ArrayList<String> randomAnswers = new ArrayList<>();
    	randomAnswers.add(question.getCorrectAnswer());
    	randomAnswers.add(question.getAnswerNumberOne());
    	randomAnswers.add(question.getAnswerNumberTwo());
    	randomAnswers.add(question.getAnswerNumberThree());
    	Collections.shuffle(randomAnswers);
    	return randomAnswers;
    	
    }
    
    //this method get the 4 shuffle answers and put them on the buttons
    public void setAnswersOnButtons(ArrayList<String> randomAnswers) {
     	buttonNumberOne.setText(randomAnswers.get(0));
    	buttonNumberTwo.setText(randomAnswers.get(1));
    	buttonNumberThree.setText(randomAnswers.get(2));
    	buttonNumberFour.setText(randomAnswers.get(3));
    }
    
    
    //This method discover the correct answer when the user choose wrong answer
    public void discoverCorrectAnswer(){
    	String correctAnswer = arrayQusetions[index].getCorrectAnswer();
    	
    	if(correctAnswer.equals(buttonNumberOne.getText())) {
    		buttonNumberOne.setBackground(greenColor);
    	}
    	else if(correctAnswer.equals(buttonNumberTwo.getText())) {
    		buttonNumberTwo.setBackground(greenColor);
    	}
    	else if(correctAnswer.equals(buttonNumberThree.getText())) {
    		buttonNumberThree.setBackground(greenColor);
    	}
    	else {
    		buttonNumberFour.setBackground(greenColor);
    	}
    		
    }
    
    //this method set the buttons color in the regular color
    public void clearAnswersColor() {
    	buttonNumberOne.setBackground(regularColor);
    	buttonNumberTwo.setBackground(regularColor);
    	buttonNumberThree.setBackground(regularColor);
    	buttonNumberFour.setBackground(regularColor);
    }
    
    

}

