package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleTests {

    @Test
    public void testsTwoLessThree(){
    int a = 2;
    int b = 3;
        Assertions.assertTrue(a < b, "Число " + b + " больше, чем число " + a);
    }
    @Test
    @DisplayName("тест суммы 2+3")
    public void testSumAAndB(){
        int a = 2;
        int b = 3;
        int sum =a+b;
        Assertions.assertEquals(5,sum);
    }

}
