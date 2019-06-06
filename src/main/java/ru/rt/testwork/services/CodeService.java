package ru.rt.testwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rt.testwork.dao.CountryDao;
import ru.rt.testwork.entities.CountryEntity;

import java.util.List;

@Service
public class CodeService {

    @Autowired
    @Qualifier("countryDaoH2Impl")
    CountryDao countryDao;

    public String getCodeByCountryName(String countryName){
        List<CountryEntity> countryEntityList = countryDao.getCountriesByName(countryName);
        if(countryEntityList != null){
            if(countryEntityList.size()>0) {
                return countryEntityList.get(0).getPhoneCode();
            }
        }
        return null;
    }
}
