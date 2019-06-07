package ru.rt.testwork.dao;

import ru.rt.testwork.entities.CountryEntity;

import java.util.List;

public interface CountryDao {

     void saveCountryList(List<CountryEntity> countryEntityList);

    List<CountryEntity> getCountriesByName(String name);
}
