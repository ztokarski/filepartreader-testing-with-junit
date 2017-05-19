import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by ztokarski on 17.05.17.
 */
public class FilePartReaderTest {

    @Test
//  #2 tests whether calling setup() with fromLine argument less than (LT) 1 throws a IllegalArgumentException.
    public void testSetupFromLineLT1() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("filePath", -1, 2);
        });
    }

    @Test
//  #3 tests whether calling setup() with argument toLine less than fromLine throws a IllegalArgumentException.
    public void testSetupToLineLTFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("filePath", 3, 2);
        });
    }

    @Test
//  #4 tests whether readLines() called to read first two lines returns expected string.
    public void testReadLines1_2() {
        FilePartReader filePartReader = new FilePartReader();
        String expected = "1a1 2b 2a ";
        String actual = filePartReader.readlines("test_data.txt", 1, 2);
        assertEquals(expected, actual);
    }

    @Test
//  #5 tests reading lines from 2 to 4.
    public void testReadLines2_4() {
        FilePartReader filePartReader = new FilePartReader();
        String expected = "2b 2a 3c 3b 3a 4d 4cr 4bb4 4a ";
        String actual = filePartReader.readlines("test_data.txt", 2, 4);
        assertEquals(expected, actual);
    }

    @Test
//  #6 tests reading all lines from file.
    public void testReadLinesAll() {
        FilePartReader filePartReader = new FilePartReader();
        String expected = "1a1 2b 2a 3c 3b 3a 4d 4cr 4bb4 4a 5e 5d 5c 5b 5ax "
            + "6f 6ea 6d 6ca 6bb 6a 7g 7f 7ea ";
        String actual = filePartReader.readlines("test_data.txt");
        assertEquals(expected, actual);
    }

}


