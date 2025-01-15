 package tests;

import models.People;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

 public class SimpleTests {

     private static Stream <Arguments> testPeople(){
         return Stream.of(
                 Arguments.of(new People("Stas",18,"male")),
                 Arguments.of(new People("Stas",18,"male")),
                 Arguments.of(new People("Stas",18,"male"))
                 );
     }
    @ParameterizedTest
    @MethodSource("testPeople")
    public void LessonParam(People people){
        System.out.println(people.getName() +" " + people.getAge() + " " + people.getSex());
        Assertions.assertTrue(people.getName().contains("s"));

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
