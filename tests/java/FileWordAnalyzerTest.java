import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Created by ztokarski on 19.05.17.
 */
public class FileWordAnalyzerTest {

    @Test
//  #1 test wordsByAbc method for lines 2-4.
    public void testAbc2_4() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",2,4);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("2a", "2b", "3a", "3b", "3c", "4a", "4bb4", "4cr", "4d"));
        List<String> actual = fileWordAnalyzer.wordsByABC(filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #2 test wordsByAbc method for line 2.
    public void testAbc2() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",2,2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("2a", "2b"));
        List<String> actual = fileWordAnalyzer.wordsByABC(filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #3 test wordsByAbc method for all lines.
    public void testAbcAllLines() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",1,7);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("1a1", "2a", "2b", "3a", "3b", "3c", "4a", "4bb4",
            "4cr", "4d", "5ax", "5b", "5c", "5d", "5e", "6a", "6bb", "6ca", "6d", "6ea", "6f", "7ea", "7f", "7g" ));
        List<String> actual = fileWordAnalyzer.wordsByABC(filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #4 test wordsContainingSubString method for lines 5-6 and string "a".
    public void testSubString5_6() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",5,6);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("5ax", "6ea", "6ca", "6a" ));
        List<String> actual = fileWordAnalyzer.wordsContainingSubString("a",filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #5 test wordsContainingSubString method for lines 3 and string "3".
    public void testSubString3() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",3,3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("3c", "3b", "3a" ));
        List<String> actual = fileWordAnalyzer.wordsContainingSubString("3",filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #6 test wordsContainingSubString method for lines 5-6 and string "bb".
    public void testSubStringAll() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",1,7);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("4bb4", "6bb" ));
        List<String> actual = fileWordAnalyzer.wordsContainingSubString("bb",filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #7 test wordsArePalindrome method for line 1.
    public void testPalindrome1() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",1,1);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("1a1"));
        List<String> actual = fileWordAnalyzer.wordsArePalindrome(filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #8 test wordsArePalindrome method for lines 2-4.
    public void testPalindrome2_4() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",2,4);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("4bb4"));
        List<String> actual = fileWordAnalyzer.wordsArePalindrome(filePartReader);
        assertEquals(expected, actual);
    }

    @Test
//  #9 test wordsArePalindrome method for all lines.
    public void testPalindromeAllLines() {
        FilePartReader filePartReader = new FilePartReader("test_data.txt",1,7);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
        List<String> expected = new ArrayList<>(Arrays.asList("1a1", "4bb4"));
        List<String> actual = fileWordAnalyzer.wordsArePalindrome(filePartReader);
        assertEquals(expected, actual);
    }



}
