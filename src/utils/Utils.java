package utils;

import model.City;

import java.util.List;

public class Utils {
    public static void printCities(List<City> cities) {
        if (cities == null) {
            System.out.println("Cities list is empty.");
        } else {
            cities.forEach(System.out::println);
        }
    }
}