import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateMethodsTest {
    private final CalculateMethods calculateMethods = new CalculateMethods();

    @Test
    public void testAdd() {
        assertEquals(10, calculateMethods.add(4, 6));
    }

    @Test
    public void testDivide() {
        assertThrows(ArithmeticException.class, () -> calculateMethods.divide(1, 0));
    }
}
