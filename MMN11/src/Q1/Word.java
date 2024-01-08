package Q1;
public class Word{


    private String currWord;//the current word after each guess mix with the lines and the correct guesses
    private String charOption;//all the letters that the user still can guess
    private boolean guesses[];//boolean array - each cell represent letter if true the user already guess this letter other he is not. 
    private int numOfGuess;//number of guesses, only legal guess that chosen from the char option will be count 


    public Word(String word) {//constructor
        this.currWord= drawLines(word);
        this.charOption = "a b c d e f g h i j k l m n o p q r s t u v w x y z  ";
        this.guesses = new boolean[26];
        this.numOfGuess=0;
    }
    
    public String drawLines(String word){//draw lines in length of the word
        String str="";
        for(int i=0;i<word.length();i++)
            str+="_ ";
        return str;

    }
    public boolean alreadyGuessedCheck(String input) {//check if the letter is already guessed
        return guesses[input.charAt(0)-97];
    }

    public int charInWord(String input,String rnd_word) {//check if the guess is correct and the letter is in this word
        guesses[input.charAt(0)-97]=true;
        return rnd_word.lastIndexOf(input);

    }

    public String getCurrWord() {//return the current word
        return currWord;
    }
    
    public void setCurrWord(String input , int index) {//put the correct letter guess in it place instead of the line
        this.currWord = currWord.substring(0,index) + input + currWord.substring(index+1);
    }
    
    public String getCharOptions() {//return the char options
        return charOption;
    }
    
    public void setCharOptions(String input) {//delete the letter that the user guessed from the letters options
    	int index;
    	index = charOption.indexOf(input);
        this.charOption = charOption.substring(0,index) + charOption.substring(index+2);
    }

    public int getNumOfGuess(){//return the number of guess
        return numOfGuess;
    }
    public void setNumOfGuess(){//update the number of guess
        numOfGuess++;
    }

}