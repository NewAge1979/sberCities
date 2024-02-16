package service;

import model.City;

import java.util.List;
import java.util.Optional;

public interface CityServ {
    List<City> getAllCities();
    List<City> sortCitiesByName();
    List<City> sortCitiesByDistrictAndName();
    Optional<City> getBigCity();
}