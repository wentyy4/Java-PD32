import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testAddition() {
        double a = 1;
        double b = 2;
        double expected = 3;
        double actual = Calculator.addition(a, b);
        assert expected == actual;
    }

    @Test
    public void testSubtraction() {
        double a = 1;
        double b = 2;
        double expected = -1;
        double actual = Calculator.subtract(a, b);
        assert expected == actual;
    }

    @Test
    public void testMultiplication() {
        double a = 1;
        double b = 2;
        double expected = 2;
        double actual = Calculator.multiply(a, b);
        assert expected == actual;
    }

    @Test
    public void testDivision() {
        double a = 1;
        double b = 2;
        double expected = 0.5;
        double actual = Calculator.divide(a, b);
        assert expected == actual;
    }

    @Test
    public void testInvalidDivision() {
        double a = 1.0;
        double b = 0.0;
        assertThrows(ArithmeticException.class, () -> Calculator.divide(a, b));

    }
}
