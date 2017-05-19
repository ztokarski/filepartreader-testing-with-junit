import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ztokarski on 17.05.17.
 */
public class Main {

    public static void main(String[] args) {
//        System.out.println("Start");
        FilePartReader filePartReader = new FilePartReader("test_data.txt",6,6);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        filePartReader.readlines("test_data.txt",2,3);
//        System.out.println(filePartReader.readlines("test_data.txt"));

        System.out.println(fileWordAnalyzer.wordsByABC(filePartReader));
        System.out.println(fileWordAnalyzer.wordsArePalindrome(filePartReader));
        System.out.println(fileWordAnalyzer.wordsContainingSubString("a", filePartReader));


    }

}
