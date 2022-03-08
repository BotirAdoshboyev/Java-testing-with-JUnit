import exceptions.GeneralException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank account nested test")
public class BankAccountNestedTest {

    @Test
    @DisplayName("Account is active after creation")
    public void testActive() {
        BankAccount account = new BankAccount("Botir", 100);
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Account holder name is not null")
    public void testHolderName() {
        BankAccount account = new BankAccount("Botir", 1000);
        assertNotNull(account.getHolderName());
    }

    @Test
    @DisplayName("Can't withdraw below minimum")
    public void testWithdrawBelowMinBalance() {
        BankAccount account = new BankAccount("Botir", 1000, -1000);
        assertThrows(GeneralException.class, () -> account.withdraw(4000));
    }

    @Test
    @DisplayName("Successfully deposit and withdraw")
    public void depositAndWithdraw() {
        BankAccount account = new BankAccount("Botir", 1000, -1000);
        assertAll(() -> account.deposit(1000), () -> account.withdraw(1500));
    }

    @Nested
    @DisplayName("When balance is 0 or negative")
    class WhenBalanceIsZero {

        @Test
        @DisplayName("Withdraw from min balace is 0")
        public void withdrawFromMinBalanceIs0() {
            BankAccount account = new BankAccount("Botir", 0, 0);
            assertThrows(GeneralException.class, () -> account.withdraw(100));
        }

        @Test
        @DisplayName("Withdraw from min balance negative (-100)")
        public void withdrawFromMinBalanceNegative100() {
            BankAccount account = new BankAccount("Botir", 0, -100);
            assertEquals(-50, account.withdraw(50));
        }
    }
}
