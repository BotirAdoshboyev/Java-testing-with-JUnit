import exceptions.GeneralException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTestWithDI {

    @Test
    @DisplayName("Throws Exception when withdraw below min balance")
    public void testWithdrawBelowMinBalance(BankAccount account) {
        assertThrows(GeneralException.class, () -> account.withdraw(80.0));
    }
}
