import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void testItemProperties() {
        Item item = new Item();
        // jestli existuje ten objekt
        assertNotNull(item);
    }
}
