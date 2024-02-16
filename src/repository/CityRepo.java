package repository;

import model.City;

import java.util.List;

public interface CityRepo {
    List<City> getAllCities();
    List<City> sortCitiesByName();
    List<City> sortCitiesByDistrictAndName();
}