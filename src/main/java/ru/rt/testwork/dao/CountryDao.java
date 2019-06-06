package ru.rt.testwork.dao;

import ru.rt.testwork.entities.CountryEntity;

import java.util.List;

public interface CountryDao {

     void saveCountryList(List<CountryEntity> countryEntityList) throws Exception;

    List<CountryEntity> getCountriesByName(String name);
}
