package service;

import model.City;
import repository.CityRepo;

import java.util.*;

public class CityServImpl implements CityServ {
    private final CityRepo cityRepo;

    public CityServImpl(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepo.getAllCities();
    }

    @Override
    public List<City> sortCitiesByName() {
        return cityRepo.sortCitiesByName();
    }

    @Override
    public List<City> sortCitiesByDistrictAndName() {
        return cityRepo.sortCitiesByDistrictAndName();
    }

    @Override
    public Optional<City> getBigCity() {
        return cityRepo.getBigCity();
    }

    @Override
    public TreeMap<String, Long> getCitiesByRegion() {
        return cityRepo.getCitiesByRegion();
    }
}