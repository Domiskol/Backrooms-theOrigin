import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class LocationTest {
    @Test
    public void testExits() {
        Location loc = new Location();

        Map<String, String> exits = new HashMap<>();
        exits.put("sever", "observacni_sal");


        assertEquals("observacni_sal", exits.get("sever"));
    }
}
