import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine cannot be lower than 1");
        }
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine cannot be lower than fromLine");
        }
        else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
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

    public String readlines() {
        try
        {
            LineNumberReader rdr = new LineNumberReader(new FileReader(this.filePath));
            StringBuilder sb = new StringBuilder();
            for (String line = null; (line = rdr.readLine()) != null;) {
                if (rdr.getLineNumber() >= this.fromLine &&
                    rdr.getLineNumber() <= this.toLine) {
                    sb.append(line);
                    sb.append(" ");
                }
            }
            return sb.toString();
            }
        catch (FileNotFoundException e) {
            System.out.println("File not found, check your setup method");
        }
        catch (IOException e) {
            System.err.println("IOException");
        }

        return "";
    }

    //  read all lines from file
    public String readlines(String filePath) {
        FilePartReader fpr = new FilePartReader();
        try {
            return fpr.read(filePath);
        }
        catch (IOException e) {
            System.err.println("File Not Found");
        }
        return null;
    }
}

