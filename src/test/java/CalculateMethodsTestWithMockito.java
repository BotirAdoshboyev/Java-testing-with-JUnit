import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateMethodsTestWithMockito {

    @Mock
    CalculateMethods calculateMethods;

    @BeforeEach
    public void setUpMock() {
        Mockito.when(calculateMethods.divide(10, 2)).thenReturn(5.0);
    }

    @Test
    public void testDivide() {
        assertEquals(5.0, calculateMethods.divide(10, 2));
    }
}
