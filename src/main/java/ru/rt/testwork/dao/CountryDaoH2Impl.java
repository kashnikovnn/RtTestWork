package ru.rt.testwork.dao;

import org.springframework.stereotype.Component;
import ru.rt.testwork.entities.CountryEntity;

import java.util.List;

@Component
public class CountryDaoH2Impl implements CountryDao {

    @Override
    public void saveCountryList(List<CountryEntity> countryEntityList) {
        System.out.println("Persist");

    }
}
