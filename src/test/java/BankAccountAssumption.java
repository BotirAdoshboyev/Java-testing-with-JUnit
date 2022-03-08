import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("Bank account assumption class")
public class BankAccountAssumption {

    @Test
    @DisplayName("Account is active after creation")
    public void testActive() {
        BankAccount account = new BankAccount("Botir", 1000, -1000);
        assumeTrue(account != null);
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Account is active aftre creation, test with assumeThat()")
    public void testActiveWithAssumingThat() {
        BankAccount account = new BankAccount("Botir", 1000, -1000);
//        account.setActive(false);
        assumingThat(account.isActive(), () -> assertEquals(500 , account.withdraw(500)));
    }
}
