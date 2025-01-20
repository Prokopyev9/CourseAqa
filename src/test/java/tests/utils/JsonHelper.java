package tests.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.People;

import java.io.File;

public class JsonHelper {


    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T fromJson(String jsonPath, Class<T> out) {
        try {
            return mapper.readValue(new File(jsonPath), out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    public static <T> T fromJsonString(String json, Class <T> out){
        return mapper.readValue(json,out);
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


