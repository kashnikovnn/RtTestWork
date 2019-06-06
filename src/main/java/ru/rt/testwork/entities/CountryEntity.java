package ru.rt.testwork.entities;

public class CountryEntity {
    String code;

    String name;

    String phoneCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }
}
