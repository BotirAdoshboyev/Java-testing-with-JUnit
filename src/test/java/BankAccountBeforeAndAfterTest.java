import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountBeforeAndAfterTest {

    static BankAccount account;

    @BeforeAll
    static void testPrep() {
        account = new BankAccount("Botir", 500, 0);
    }

//    @BeforeEach
//    public void initializeAccount() {
//        account = new BankAccount("Botir", 500, 0);
//    }

//    @AfterAll
//    public static void afterTest() {
//        System.out.println("after test");
//    }

//    @AfterEach
//    public void afterEachTest() {
//        System.out.println("After each");
//    }

    @Test
    @DisplayName("Deposite success")
    public void deposit300() {
        account.deposit(300);
        assertEquals(800, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw success")
    public void withdraw400() {
        account.withdraw(400);

        // With beforeAll, account is initialized once
        assertEquals(400, account.getBalance());

        // With beforeEach as before each test account is reinitialised
//        assertEquals(100, account.getBalance());
    }
}
