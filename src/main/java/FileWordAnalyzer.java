import java.util.ArrayList;

/**
 * Created by ztokarski on 17.05.17.
 */
public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public FileWordAnalyzer() {
        this.filePartReader = new FilePartReader();
    }

    public FilePartReader getFilePartReader() {
        return filePartReader;
    }

    public void setFilePartReader(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> wordsByABC(FilePartReader filePartReader) {
        String allWords = filePartReader.readlines(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine());
        ArrayList<String>wordsByAbc = new ArrayList<>();
        for(String word : allWords.split(" ")) {
            wordsByAbc.add(word);
        }
        java.util.Collections.sort(wordsByAbc);
        return wordsByAbc;
    }

    public ArrayList<String> wordsContainingSubString(String subString, FilePartReader filePartReader) {
        String allWords = filePartReader.readlines(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine());
        ArrayList<String>subStringList = new ArrayList<>();
        for (String word : allWords.split(" ")) {
            if (word.contains(subString)) {
                subStringList.add(word);
            }
        }
        return subStringList;
    }

    public ArrayList<String> wordsArePalindrome(FilePartReader filePartReader) {
        String allWords = filePartReader.readlines(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine());
        ArrayList<String>palindromeList = new ArrayList<>();
        for(String word : allWords.split(" ")) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromeList.add(word);
            }
        }
        return palindromeList;

    }

}
