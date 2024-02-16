package repository;

import model.City;

import java.util.*;

public interface CityRepo {
    List<City> getAllCities();
    List<City> sortCitiesByName();
    List<City> sortCitiesByDistrictAndName();
    Optional<City> getBigCity();
    TreeMap<String, Long> getCitiesByRegion();
}