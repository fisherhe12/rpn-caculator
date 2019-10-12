package com.fisher;

import static com.fisher.common.OperatorConstants.DEFAULT_FORMAT_PRECISION;
import static org.junit.Assert.assertEquals;

import com.fisher.exception.InsufficientOperandsException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test unit for calculator
 *
 * @author Yu.He
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void testWithNoOperator() {
        calculator.reset();
        String result = calculator.execute("1 2");
        assertEquals("1.0000000000 2.0000000000", result);
    }

    @Test
    public void testWithUndoOperator() {
        calculator.reset();
        String result = calculator.execute("6 3 1 + 5 * undo +");
        assertEquals(new BigDecimal("10").setScale(DEFAULT_FORMAT_PRECISION,
            RoundingMode.HALF_UP).toString(), result);
    }

    @Test(expected = InsufficientOperandsException.class)
    public void testWithInsufficientException() {
        calculator.reset();
        calculator.execute("3 -");
    }

    @Test
    public void testWithClearOperator() {
        calculator.reset();
        String result = calculator.execute("3 4 + clear 1");
        assertEquals(
            new BigDecimal("1").setScale(DEFAULT_FORMAT_PRECISION, RoundingMode.HALF_UP).toString(),
            result);
    }

    @Test
    public void testWithCompoundInstruction() {
        calculator.reset();
        String result = calculator.execute("6 5 4 3");
        assertEquals("6.0000000000 5.0000000000 4.0000000000 3.0000000000", result);
        result = calculator.execute("undo undo *");
        assertEquals("30.0000000000", result);
        result = calculator.execute("10 *");
        assertEquals("300.0000000000", result);
        result = calculator.execute("undo");
        assertEquals("30.0000000000", result);
    }

    @After
    public void destroy() {
        calculator = null;
    }

}
