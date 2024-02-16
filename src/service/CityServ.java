package service;

import model.City;

import java.util.List;

public interface CityServ {
    List<City> getAllCities();
    List<City> sortCitiesByName();
    List<City> sortCitiesByDistrictAndName();
}