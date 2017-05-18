import java.io.IOException;

/**
 * Created by ztokarski on 17.05.17.
 */
public class Main {

    public static void main(String[] args) {
//        System.out.println("Start");
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.readlines("test_data.txt",2,3);
        System.out.println(filePartReader.readlines("test_data.txt",1,100));


//        filePartReader.setup("asdff",6, 8);
    }

}
