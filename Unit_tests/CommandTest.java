import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {
    @Test
    public void testQuitCommand() {
        Quit quit = new Quit();
        assertTrue(quit.exit(), "Quit command must return true for exit()");
        assertEquals("Program byl ukoncen", quit.execute());
    }
}
