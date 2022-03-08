import exceptions.GeneralException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test bank account class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 80 successfully")
    public void testWithdraw() {
        BankAccount account = new BankAccount("Botir", 100);
        assertEquals(20, account.withdraw(80.0));
    }

    @Test
    @DisplayName("Deposit 100 successfully")
    public void testDeposit() {
        BankAccount account = new BankAccount("Botir", 100);
        assertEquals(200, account.deposit(100));
        assertThrows(GeneralException.class, () -> account.deposit(-10.0));
    }

    @Test
    @DisplayName("Account is active after creation")
    public void testActive() {
        BankAccount account = new BankAccount("Botir", 100);
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Account holder name is not null")
    public void testHolderName(){
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

    @Test
    @DisplayName("Not taking long time")
    public void testDepositTimeOut() {
        BankAccount account = new BankAccount("Botir", 1000, -1000);
        assertTimeout(Duration.ofNanos(1), () -> account.deposit(1000));
    }
}
