import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
@DisplayName("Bank account parameterized test")
public class BankAccountParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30, 40})
    @DisplayName("Throws Exception when withdraw below min balance")
    public void testWithdrawBelowMinBalance(int amount, BankAccount account) {
        assertEquals(-amount, account.withdraw(amount));
    }

    @ParameterizedTest
//    @CsvSource({"Botir, 100", "Jasur, 200", "Diyor, 300"})
    @CsvFileSource(resources = "accountDetails.csv")
    @DisplayName("Holder name and deposit successful")
    public void testDepositAndHolderName(String holderName, int amount, BankAccount account) {
        account.deposit(amount);
        account.setHolderName(holderName);
        assertEquals(amount, account.getBalance());
        assertEquals(holderName, account.getHolderName());
    }
}
