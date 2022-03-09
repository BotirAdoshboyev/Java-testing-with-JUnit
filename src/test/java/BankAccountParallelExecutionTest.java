import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Deposit 100 successfully")
    public void testDeposit1(BankAccount account) {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 100 successfully")
    public void testDeposit2(BankAccount account) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(150);
        assertEquals(150, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 100 successfully")
    public void testDeposit3(BankAccount account) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(150);
        assertEquals(150, account.getBalance());
    }
}
