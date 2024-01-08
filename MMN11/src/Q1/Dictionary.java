package Q1;
import java.util.Random;


public class Dictionary{

	//bank of words
    private static final String dict [] = {"hello","farewell","overeat","harmony","east","professor"
    										,"artist","fuss","lineage","comfort","rabbit","nominate"
    										,"generate","sector","tycoon", "bed","coat","margin"
    										,"shareholder","sheep","functional","location","card"
    										,"throne","concentration","tip","shape","love","israel"};

    public static String getRandomWord() {//choosing random word from the bank
        Random r = new Random();
        return dict[r.nextInt(dict.length)];

    }


}