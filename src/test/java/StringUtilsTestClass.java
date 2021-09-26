import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTestClass {

    private StringUtils stringUtils;

    @BeforeEach
    void somePrepareBeforeTest() {
        stringUtils = new StringUtils();
    }

    @Test
    void isPositiveNumberTest() {
        assertTrue(stringUtils.isPositiveNumber("0xFD"));
    }

    @Test
    void isNegativeNumberTest() {
        assertFalse(stringUtils.isPositiveNumber("-24"));
    }

    @Test
    void callExceptionTest() {
        assertThrows(RuntimeException.class, () -> {
            stringUtils.isPositiveNumber("not number");
        });
    }


}
