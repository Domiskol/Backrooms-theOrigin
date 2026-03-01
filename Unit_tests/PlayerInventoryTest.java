import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerInventoryTest {
    @Test
    public void testInventoryLimit() {
        Player player = new Player();
        Item item = new Item();


        for(int i=0; i<5; i++) {
            assertTrue(player.pickUpItem(item), "Should be able to pick up item " + i);
        }

        // vic itemu by nemelo jit
        assertFalse(player.pickUpItem(item), "Should not be able to pick up 6th item");
    }
}
