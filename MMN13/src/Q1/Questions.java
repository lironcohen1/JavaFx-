/****************************************************************
This class contain in one object the question the right answer 
and 3 more wrong answer to the same question
****************************************************************/



package Q1;

public class Questions {
	
	
	private String question;
	private String correctAnswer;
	private String answerNumberOne;
	private String answerNumberTwo;
	private String answerNumberThree;
	
	public Questions(String question ,String correctAnswer,String answerNumberOne,String answerNumberTwo,String answerNumberThree ) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answerNumberOne = answerNumberOne;
		this.answerNumberTwo = answerNumberTwo;
		this.answerNumberThree = answerNumberThree;
	}
	
	
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
	
	public String getAnswerNumberOne() {
		return this.answerNumberOne;
	}
	
	public String getAnswerNumberTwo() {
		return this.answerNumberTwo;
	}
	
	public String getAnswerNumberThree() {
		return this.answerNumberThree;
	}
	
	
	
	
	
	
	
	
}
