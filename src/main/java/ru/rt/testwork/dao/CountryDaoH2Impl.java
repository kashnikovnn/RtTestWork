package ru.rt.testwork.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.rt.testwork.entities.CountryEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class CountryDaoH2Impl implements CountryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveCountryList(List<CountryEntity> countryEntityList) throws Exception {
        String sql = "MERGE INTO COUNTRIES KEY(CODE) VALUES (?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,countryEntityList.get(i).getCode());
                preparedStatement.setString(2,countryEntityList.get(i).getName());
                preparedStatement.setString(3,countryEntityList.get(i).getPhoneCode());
            }

            @Override
            public int getBatchSize() {
                return countryEntityList.size();
            }
        });
        throw new Exception("Ebala zjaba gadyku");

    }

    @Override
    public List<CountryEntity> getCountriesByName(String name) {
        String sql = "SELECT CODE, NAME, PHONECODE FROM COUNTRIES WHERE LOWER(NAME) = LOWER(?)";
        List<CountryEntity> countryEntityList = jdbcTemplate.query(sql, new String[]{name}, new RowMapper<CountryEntity>() {
            @Override
            public CountryEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                CountryEntity countryEntity = new CountryEntity();
                countryEntity.setCode(resultSet.getString(1));
                countryEntity.setName(resultSet.getString(2));
                countryEntity.setPhoneCode(resultSet.getString(3));
                return countryEntity;
            }
        });

        return countryEntityList;
    }
}
