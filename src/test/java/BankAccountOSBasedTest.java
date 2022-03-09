import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountOSBasedTest {

    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac() {
        assertEquals(10, 10);
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testWindows() {
        assertEquals(10, 10);
    }

    @Test
    @EnabledOnOs({OS.LINUX})
    public void testLinux() {
        assertEquals(10, 10);
    }

    @Test
    @EnabledOnJre({JRE.JAVA_11})
    public void testJRE11() {
        assertEquals(10, 10);
    }

    @Test
    @Disabled("Temporarily disabled for a reason")
    public void testDisabled() {
        assertEquals(10, 10);
    }
}
