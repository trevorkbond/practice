import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game g;

    @BeforeEach
    void setup() {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }
    @Test
    @DisplayName("Test Gutter Game")
    public void testGutterGame() throws Exception {
        rollMany(20 , 0);
        Assertions.assertEquals(0, g.score());
    }
    @Test
    @DisplayName("Test All Ones")
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        Assertions.assertEquals(20, g.score());
    }
    @Test
    @DisplayName("Test One Spare")
    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }
    @Test
    @DisplayName("Test One Strike")
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    @DisplayName("Perfect Game")
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }

    private void rollStrike() {
        g.roll(10);
    }
    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
}