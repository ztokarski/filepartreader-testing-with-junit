import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.Scanner;


/**
 * Created by ztokarski on 17.05.17.
 */
public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }

    public void setToLine(Integer toLine) {
        this.toLine = toLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine cannot be lower than 1");
        }
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine cannot be lower than fromLine");
        }
    }

    public String read(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }


//  read all lines from file
    public String readlines (String filePath) {
        FilePartReader fpr = new FilePartReader();
        try {
            return fpr.read(filePath);
        }
        catch (IOException e) {
            System.err.println("File Not Found");
        }
        return null;
    }


    public String readlines (String filePath, Integer fromLine, Integer toLine) {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(filePath, fromLine, toLine);

        try
        {
            String str = fpr.read(filePath);
            LineNumberReader rdr = new LineNumberReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            for (String line = null; (line = rdr.readLine()) != null;) {
                if (rdr.getLineNumber() >= fromLine &&
                    rdr.getLineNumber() <= toLine) {
                    sb.append(line);
                    sb.append(" ");
                }
            }
            return sb.toString();
            }
        catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        }
        catch (IOException e) {
            System.err.println("IOException");
        }

        return null;
    }

    @Override
    public String toString() {
        return this.filePath;
    }
}

