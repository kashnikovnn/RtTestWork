package ru.rt.testwork.dataloaders;

import ru.rt.testwork.entities.CountryEntity;

import java.util.List;

public interface DataLoader {

    List<CountryEntity> getCountryData() throws Exception;

}
