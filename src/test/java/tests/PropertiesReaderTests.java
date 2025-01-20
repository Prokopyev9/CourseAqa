package tests;

import lombok.SneakyThrows;
import models.Settings;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.utils.AppConfig;
import tests.utils.JsonHelper;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReaderTests {

    @Test
    @SneakyThrows
    public void simpleReaderTest(){
        Properties properties = new Properties();
        FileInputStream fs = new FileInputStream("src/test/resources/project.properties");
        properties.load(fs);

        String url = properties.getProperty("url");
        Boolean isProduction = Boolean.parseBoolean(properties.getProperty("is_production"));
        int threads = Integer.parseInt(properties.getProperty("threads"));

        System.out.println(url);
        System.out.println(isProduction);
        System.out.println(threads);
    }

    @Test
    @SneakyThrows
    public void jacksonReaderTest() {
        Properties properties = new Properties();
        FileInputStream fs = new FileInputStream("src/test/resources/project.properties");
        properties.load(fs);

        String json = JsonHelper.toJson(properties);

        Settings settings = JsonHelper.fromJsonString(json, Settings.class);
        System.out.println(settings.getUrl());
        System.out.println(settings.getIsProduction());
        System.out.println(settings.getThreads());
    }
    @Test
    public void ownerReaderTest(){
        AppConfig appConfig = ConfigFactory.create(AppConfig.class);
        System.out.println(appConfig.prod());
        System.out.println(appConfig.url());
        System.out.println(appConfig.threads());
    }
    @Test
    public void test(){
        int a = 5;
        int b = 7;
        int c = a+b;
        Assertions.assertEquals(c,12);
        System.out.println(a+b);
    }
}
