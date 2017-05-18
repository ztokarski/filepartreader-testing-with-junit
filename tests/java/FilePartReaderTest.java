import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by ztokarski on 17.05.17.
 */
public class FilePartReaderTest {

    @Test
    public void testSetupFromLineLT1() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("filePath", -1, 2);
        });
    }

    @Test
    public void testSetupToLineLTFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("filePath", 3, 2);
        });
    }
}

