package ru.rt.testwork.dataloaders;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HttpDataLoaderTest {

    HttpDataLoader httpDataLoader = new HttpDataLoader();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getJson() {

        try {
            System.out.println("\n\nRequest: "+httpDataLoader.getJson("http://country.io/phone.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}