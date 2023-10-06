import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {
   Customer customer = new Customer();

    @BeforeEach
    void createCalculator() {
        customer = new Customer();
    }

    @Test
    void setName_NameNull_ThrowException() {
        assertThrows(IllegalArgumentException.class, () ->  customer.setName(null));
    }

    @Test
    void setName_NameLessTwoSymbols_ThrowException() {
        assertThrows(IllegalArgumentException.class, () ->  customer.setName("a"));
    }

    @Test
    void setName_NameMore1000Symbols_ThrowException() {
        StringBuilder testName = new StringBuilder();
        for(int i=0; i<=1010;i++){
            testName.append("a");
        }
        assertThrows(IllegalArgumentException.class, () ->  customer.setName(testName.toString()));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Jack", "Harry", "Jacob","Charlie" })
    void setName_NameLess1000AndMoreTwoSymbols_DoesntThrowException(String name) {
        assertDoesNotThrow(() ->  customer.setName(name));
    }
}