package org.manu.calculator;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Manu on 22-Nov-14.
 */
@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {
    int num1;
    int num2;
    int sum;

    public CalculatorParameterizedTest(int num1, int num2, int sum) {
        this.num1 = num1;
        this.num2 = num2;
        this.sum = sum;
    }

    @Parameters
    public static Collection addedNumbers() {
        return Arrays.asList(new Integer[][]{
                {1, 2, 3},
                {20, 30, 50}
        });
    }

    @Test
    public void shouldGetSum() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(num1, num2);
        Assert.assertThat(sum, CoreMatchers.is(this.sum));
    }



}

