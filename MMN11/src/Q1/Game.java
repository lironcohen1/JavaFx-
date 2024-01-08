
package Q1;

import java.util.Scanner;

public class Game{
    
    private String rndWord;
    private String cpyRndWord;
    private String input;
    private boolean finish;
    private int index;
    Scanner s = new Scanner(System.in);

    public Game() {//constructor
        this.rndWord="";
        this.input ="";
        this.finish = false;
    }

    public void start() {//this function manage the game
        System.out.println("Hello, you need to find the word by entering each time a\n"
                + "lower char between 'a' to 'z' if you want to stop the game enter --> exit");

        while(!input.equals("exit")) {//if the input was exit the game will finish
            rndWord = Dictionary.getRandomWord();//getting random word
            Word word = new Word(rndWord);
            finish = false;

            while(!finish) {//while the user do not find the word and still want to play. 
                System.out.println("\n" + word.getCurrWord() + "  char options: " + word.getCharOptions());
                input = s.nextLine();

                if(input.equals("exit")) {//if the user want to stop the game
                    System.out.println("Thank you for playing :)");
                    finish = true;
                    continue;
                }

                if(input.length()!=1 || input.charAt(0) < 'a' || input.charAt(0) > 'z' ) {// if the user entered invalid input.
                    System.out.println("ERROR: you must enter only one lower case each time\nplease enter again\n");
                    continue;
                }

                
                if(word.alreadyGuessedCheck(input)) {//if the user already guess this letter
                    System.out.println("ERROR: you already guessed this char\n");
                    continue;
                }
                word.setNumOfGuess();//increase number of guess +1
                word.setCharOptions(input);//delete the new char that guessed
                
                //if the user make a good guess it will put the correct letter in is position of the word instead of the line
                cpyRndWord = rndWord;
                do {
                    index = word.charInWord(input , cpyRndWord);
                    if(index==-1)
                        continue;
                    cpyRndWord = cpyRndWord.substring(0,index) + cpyRndWord.substring(index+1);
                    word.setCurrWord(input, 2*index);
                } while(index!=-1);

                //if the user find the word
                if(word.getCurrWord().indexOf("_")==-1) {
                    finish=true;
                    System.out.println("Good job :) , you succeeded\nthe word is--> " + rndWord);
                    System.out.println("number of guesses is-->" + word.getNumOfGuess());
                    System.out.println("let's began another game-->\n ");
                }
            }
        }
    }
}