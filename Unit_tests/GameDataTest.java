import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameDataTest {
    @Test
    public void testFindInvalidLocation() {
        GameData gd = new GameData();
        gd.locations = new java.util.ArrayList<>();


        assertThrows(IllegalArgumentException.class, () -> {
            gd.findLocation("non_existent_room");
        });
    }
}