package service;

import repository.CityRepo;

public class CityServImpl implements CityServ {
    private final CityRepo cityRepo;

    public CityServImpl(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public void printAllCities() {
        cityRepo.printAllCities();
    }
}