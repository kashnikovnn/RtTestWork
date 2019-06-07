package ru.rt.testwork.dataloaders;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HttpClientTest {

    HttpClient httpClient = new HttpClient();

    @Test
    public void getJson() throws Exception {

        String result = httpClient.getJson("http://country.io/phone.json");
        Assert.assertTrue(result.indexOf("\"RU\": \"7\"")>-1);

        result = httpClient.getJson("http://country.io/names.json");
        Assert.assertTrue(result.indexOf("\"RU\": \"Russia\"")>-1);

    }
}