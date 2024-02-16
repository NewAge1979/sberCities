package service;

import model.City;

import java.util.*;

public interface CityServ {
    List<City> getAllCities();
    List<City> sortCitiesByName();
    List<City> sortCitiesByDistrictAndName();
    Optional<City> getBigCity();
    TreeMap<String, Long> getCitiesByRegion();
}