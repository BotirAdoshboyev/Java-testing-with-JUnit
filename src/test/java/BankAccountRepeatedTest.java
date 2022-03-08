import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountRepeatedTest {

    @RepeatedTest(2)
    @DisplayName("Withdraw 80 successfully")
    @Order(2)
    public void testWithdraw(BankAccount account, RepetitionInfo repetitionInfo) {
        assertEquals(-80, account.withdraw(80));
        System.out.println(repetitionInfo.getCurrentRepetition());
//        System.out.println(repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(4)
    @DisplayName("Deposit 100 successfully")
    @Order(1)
    public void testDeposit(BankAccount account) {
        assertEquals(100, account.deposit(100));
    }
}
