import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedTest {
    static final BankAccount account = new BankAccount("Botir", 0, 0);

    @Test
    @DisplayName("Withdraw successful")
    @Order(2)
    public void testWithdraw() {
        assertEquals(400, account.withdraw(100));
        System.out.println(account.getBalance());
    }

    @Test
    @DisplayName("Deposit successful")
    @Order(1)
    public void testDeposit() {
        assertEquals(500, account.deposit(500));
        System.out.println(account.getBalance());
    }
}
