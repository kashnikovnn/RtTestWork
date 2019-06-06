package ru.rt.testwork.dataloaders;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rt.testwork.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DataLoaderHttpImpl implements DataLoader {

    final Logger logger = LoggerFactory.getLogger(DataLoaderHttpImpl.class);

    private HttpClient httpClient = new HttpClient();


    @Value("${countrynames.url}")
    String countryNamesUrl;

    @Value("${phonecodes.url}")
    String phonecodesUrl;

    @Override
    public List<CountryEntity> getCountryData() throws Exception {

        List<CountryEntity> countryEntityList = new ArrayList<>();
        JSONObject countrynamesJson= new JSONObject(httpClient.getJson(countryNamesUrl));
        JSONObject phonecodesJson= new JSONObject(httpClient.getJson(phonecodesUrl));
        Iterator<String> keysIterator = countrynamesJson.keys();

        while (keysIterator.hasNext()){
            String key = keysIterator.next();
            CountryEntity countryEntity= new CountryEntity();
            countryEntity.setCode(key);
            countryEntity.setName(countrynamesJson.getString(key));
            countryEntity.setPhoneCode(phonecodesJson.getString(key));
            countryEntityList.add(countryEntity);
        }

        logger.debug("Loaded list: "+countryEntityList);
        return countryEntityList;
    }
}
