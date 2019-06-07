package ru.rt.testwork.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rt.testwork.dao.CountryDao;
import ru.rt.testwork.dataloaders.DataLoader;
import ru.rt.testwork.entities.CountryEntity;

import java.util.List;


@Service
@Data
public class ReloadServiceImpl implements ReloadService{

    @Autowired
    @Qualifier("dataLoaderHttpImpl")
    DataLoader dataLoader;

    @Autowired
    @Qualifier("countryDaoH2Impl")
    CountryDao countryDao;

    public void reload() throws Exception {

        List<CountryEntity> countryEntityList = dataLoader.getCountryData();
        countryDao.saveCountryList(countryEntityList);

    }
}
