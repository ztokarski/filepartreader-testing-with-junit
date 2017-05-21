import java.util.ArrayList;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer() {
        this.filePartReader = new FilePartReader();
    }

    public ArrayList<String> wordsByABC(FilePartReader filePartReader) {
        String allWords = filePartReader.readlines();
        ArrayList<String>wordsByAbc = new ArrayList<>();
        for(String word : allWords.split(" ")) {
            wordsByAbc.add(word);
        }
        java.util.Collections.sort(wordsByAbc);
        return wordsByAbc;
    }

    public ArrayList<String> wordsContainingSubString(String subString, FilePartReader filePartReader) {
        String allWords = filePartReader.readlines();
        ArrayList<String>subStringList = new ArrayList<>();
        for (String word : allWords.split(" ")) {
            if (word.contains(subString)) {
                subStringList.add(word);
            }
        }
        return subStringList;
    }

    public ArrayList<String> wordsArePalindrome(FilePartReader filePartReader) {
        String allWords = filePartReader.readlines();
        ArrayList<String>palindromeList = new ArrayList<>();
        for(String word : allWords.split(" ")) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromeList.add(word);
            }
        }
        return palindromeList;
    }
}
