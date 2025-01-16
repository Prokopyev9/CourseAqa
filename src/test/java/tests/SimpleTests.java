 package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.People;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.ls.LSOutput;
import tests.utils.JsonHelper;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

 public class SimpleTests {

     @Test
     public void LessonParam() throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
         File file = new File("src/test/resources/Stas.json");
         People people = objectMapper.readValue(file, People.class);
         System.out.println(people.getName());
         System.out.println(people.getAge());
         System.out.println(people.getSex());

         People sasha = new People("Sasha", 10, "female");
         String json = objectMapper.writeValueAsString(sasha);
         System.out.println(json);
     }

     @Test
     public void useJsonHelper() throws IOException {
         People people = JsonHelper.fromJson("src/test/resources/stas.json",People.class);
         System.out.println(people);
         System.out.println(JsonHelper.toJson(people));
     }

 }